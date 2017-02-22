package leetcode3;

import java.util.HashMap;

public class Logger {
	HashMap<String, Integer> map = null;
	/** Initialize your data structure here. */
    public Logger() {
        this.map = new HashMap<String, Integer>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!this.map.containsKey(message)){
        	this.map.put(message, timestamp);
        	return true;
        }else{
        	int time = this.map.get(message);
        	if(timestamp - time >= 10){
        		map.put(message, timestamp);
        		return true;
        	}else return false;
        }
    }
}
