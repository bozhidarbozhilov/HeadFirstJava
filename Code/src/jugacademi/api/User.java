package jugacademi.api;


public class User implements java.io.Serializable, java.lang.Cloneable {
    private String name;
    private int age;
    private transient Object details;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {

        this.details = details;
    }

    @Override
    protected Object clone() throws java.lang.CloneNotSupportedException {
        User cloned = (User) super.clone();
        if(!(this.details instanceof java.lang.Cloneable)){
            throw new java.lang.CloneNotSupportedException();
        }else{
            cloned.setDetails(this.details);
        }

        return cloned;
    }
}
