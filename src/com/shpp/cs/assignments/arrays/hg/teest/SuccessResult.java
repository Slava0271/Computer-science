package com.shpp.cs.assignments.arrays.hg.teest;


public class SuccessResult extends TeestResult {
    public static final SuccessResult INSTANCE = new SuccessResult();

    public ResultTypeHolder.ResultType getType() {
        return ResultTypeHolder.ResultType.SUCCESS;
    }

    public String toString() {
        return "Test passed!  Nice job!";
    }
}
