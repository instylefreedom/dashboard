package dashboard.entity;


import dashboard.data.BoardDTO;
import lombok.Data;

import javax.persistence.*;

//DB 테이블 역활을 하는 클래스
@Entity
@Data
@Table(name = "board_table")
public class BoardEntity extends BaseEntity {
    @Id // pk 칼럼 지정 필수
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // auto increment
    private long id;

    @Column(length = 100, nullable = false) // 크기는 100, not null
    private String boardWriter;

    @Column // default length 255, nullable
    private String boardPass;

    @Column
    private String boardTitle;

    @Column(length = 1000)
    private String boardContents;

    @Column
    private int boardHits;

    public static BoardEntity toSaveEntity(BoardDTO boardDTO){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(boardDTO.getBoardWriter());
        boardEntity.setBoardPass(boardDTO.getBoardPass());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setBoardHits(0);
        return boardEntity;
    }

}
