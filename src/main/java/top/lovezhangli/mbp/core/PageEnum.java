package top.lovezhangli.mbp.core;

public enum PageEnum {

	homePage("homePage");

	private String name;

	private PageEnum(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static String getValue(String name) {
		PageEnum[] pageEnums = values();
        for (PageEnum pageEnum : pageEnums) {
            if (pageEnum.toString().equals(name)) {
                return pageEnum.getName();
            }
        }
        return null;
    }
}
