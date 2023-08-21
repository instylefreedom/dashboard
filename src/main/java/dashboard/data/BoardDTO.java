package dashboard.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

// DTO(Data Transfer Object), VO, Bean.  Entity 는 목적이 다름
@Data
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor // 모든 필드를 매개변수로 하는 생성자
public class BoardDTO {

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;  //조회수
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

}
