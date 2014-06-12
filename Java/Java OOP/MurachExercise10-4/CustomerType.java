public enum CustomerType {
	RETAIL,
	TRADE,
	COLLEGE;

	@Override
	public String toString() {
		switch (this.ordinal()) {
			case 0: return "Retail Customer";
			case 1: return "Trade Customer";
			case 2: return "College Customer";
			default: return "Unknown Type";
		}
	} 
}

