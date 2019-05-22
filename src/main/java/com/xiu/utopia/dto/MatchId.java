package com.xiu.utopia.dto;

import com.xiu.followdouban.commonrpc.enums.IdType;

import java.util.Objects;

/**
 * 匹配id所使用的对象
 */
public class MatchId {
    private Integer id;

    private IdType idType;

    public MatchId() {
    }

    public MatchId(Integer id, IdType idType) {
        this.id = id;
        this.idType = idType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IdType getIdType() {
        return idType;
    }

    public void setIdType(IdType idType) {
        this.idType = idType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchId matchId = (MatchId) o;
        return Objects.equals(id, matchId.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
