package dashboard.service;

import dashboard.data.BoardDTO;
import dashboard.entity.BoardEntity;
import dashboard.repository.BoardMBRepository;
import dashboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

// jpa 를 사용하면 서비스에서 하는 작업
// DTO -> Entity (entity class 에서 작업)   컨트롤러에서 DTO 로 받은 Entity 로 변경해서 작업을 하고
// Entity -> DTO (dto class 에서 작업)      jpa 가 리턴한 entity 를 DTO 로 변경해서 컨트롤러에 넘김
// entity 가 db 와 직접적 연관이 있어 뷰 쪽에는 보내지 않는것을 권고.

@Service
@RequiredArgsConstructor
public class BoardService {
//    private final BoardMBRepository boardRepository;
    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDTO) {
//        boardDTO.setBoardCreatedTime(LocalDateTime.now());
//        boardRepository.save(boardDTO);
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        boardRepository.save(boardEntity);

    }
}
