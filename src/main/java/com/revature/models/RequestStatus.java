package com.revature.models;

public enum RequestStatus {
     PENDING(0), APPROVED (1), DENIED (2);

     private int approvalStatus;
    RequestStatus(int i) {
        this.approvalStatus = i;
    }

    public int getStatus() {
        return approvalStatus;
    }

    public void setIsApproved(int isApproved) {
        this.approvalStatus = isApproved;
    }

    public static RequestStatus fromOrdinal(int n){
        switch(n){
            case 0:
                return PENDING;
            case 1:
                return APPROVED;
            case 2:
                return DENIED;
            default:
                return null;
        }
    }
}
