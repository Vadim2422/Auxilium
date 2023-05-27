package flumine.sgm.auxilium.services;

import flumine.sgm.auxilium.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AIChatService {
    final MessageRepository messageRepository;

    public AIChatService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }
    //засунь свой POST сюда семпай
}
