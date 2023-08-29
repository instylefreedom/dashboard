package dashboard.repository;

import dashboard.data.BoardDTO;
import dashboard.mapper.BoardMBMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardMBRepository {

    private final BoardMBMapper boardMapper;
//
    public int save(BoardDTO boardDTO) {
        return this.boardMapper.save(boardDTO);
    }
}
