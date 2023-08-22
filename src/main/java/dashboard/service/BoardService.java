package dashboard.service;

import dashboard.data.BoardDTO;
import dashboard.repository.BoardRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
        boardDTO.setBoardCreatedTime(LocalDateTime.now());
        boardRepository.save(boardDTO);

    }
}
