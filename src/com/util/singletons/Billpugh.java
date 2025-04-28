package com.util.singletons;

public class Billpugh {

	 private Billpugh() {}
// Bill pugh
	    private static class SingletonHolder {
	        private static final Billpugh INSTANCE = new Billpugh();
	    }

	    public static Billpugh getInstance() {
	        return SingletonHolder.INSTANCE;
	    }
	    
	    //was not immune to advanced issues like reflection or serialization or cloning


}


