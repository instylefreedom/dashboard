package dashboard.repository;

import dashboard.data.BoardDTO;
import dashboard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper boardMapper;

    public int save(BoardDTO boardDTO) {
        return this.boardMapper.save(boardDTO);
    }
}
