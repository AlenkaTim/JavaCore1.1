public class Worker {
    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    private OnTaskDoneListener callback;

    public Worker(OnTaskDoneListener callback) {
        this.callback = callback;
    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i != 33) callback.onDone("Task " + i + " is done");
            else {
                i = 33;
            }
            errorCallback.onError("Task " + " is error");
        }
    }

    public interface OnTaskErrorListener {
        void onError(String result);
    }

    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskErrorListener errorCallback) {
        this.errorCallback = errorCallback;
    }
}