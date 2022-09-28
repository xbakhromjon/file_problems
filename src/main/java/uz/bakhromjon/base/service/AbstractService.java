package uz.bakhromjon.base.service;

import lombok.AllArgsConstructor;
import uz.bakhromjon.base.mapper.BaseMapper;
import uz.bakhromjon.base.repository.BaseRepository;
import uz.bakhromjon.base.validator.BaseValidator;

@AllArgsConstructor
public abstract class AbstractService<R extends BaseRepository,
        V extends BaseValidator,
        M extends BaseMapper> implements BaseService {
    public R repository;
    public V validator;
    public M mapper;
}
