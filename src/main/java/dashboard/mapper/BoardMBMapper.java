package dashboard.mapper;

import dashboard.data.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMBMapper {
    int save(BoardDTO boardDTO);
}
