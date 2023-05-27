package flumine.sgm.auxilium.responses.openai;

import java.util.Vector;

public class OpenAIModelData {
    protected String id;
    protected String object;
    protected String organization;
    protected Vector<Object> permissions;

    public OpenAIModelData() {}

    public OpenAIModelData(String id, String object, String organization, Vector<Object> permissions) {
        this.id = id;
        this.object = object;
        this.organization = organization;
        this.permissions = permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Vector<Object> getPermissions() {
        return permissions;
    }

    public void setPermissions(Vector<Object> permissions) {
        this.permissions = permissions;
    }
}
