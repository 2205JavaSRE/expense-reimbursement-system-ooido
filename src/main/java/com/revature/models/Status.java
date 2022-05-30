package com.revature.models;

public enum Status {
     PENDING(0), APPROVED (1), DENIED (2);

     private int approvalStatus;
    Status(int i) {
        this.approvalStatus = i;
    }

    public int getStatus() {
        return approvalStatus;
    }

    public void setIsApproved(int isApproved) {
        this.approvalStatus = isApproved;
    }
}
