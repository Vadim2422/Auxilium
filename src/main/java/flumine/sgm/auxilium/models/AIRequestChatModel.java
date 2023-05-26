package flumine.sgm.auxilium.models;

import java.util.HashMap;
import java.util.List;
public class AIRequestChatModel {
    String model;

    List<String> messages;

    String name;

    public AIRequestChatModel(String model, List<String> messages, String name) {
        this.model = model;
        this.messages = messages;
        this.name = name;
    }
}
