package org.asynctaskmanager.core.domain.task;

import org.asynctaskmanager.core.domain.task.AsyncTask;

import java.util.concurrent.Future;

/**
 * Package-local AsyncTask implementation.
 */
public class FutureBackedAsyncTask implements AsyncTask {
    private final Future<?> result;
    private final String id;

    public FutureBackedAsyncTask(String id, Future<?> result) {
        this.result = result;
        this.id = id;
    }

    public FutureBackedAsyncTask(Future<?> result) {
        this.result = result;
        this.id = String.valueOf(System.identityHashCode(this));
    }


    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public boolean isDone() {
        return result.isDone();
    }
}