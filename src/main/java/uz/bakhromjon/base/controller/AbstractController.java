package uz.bakhromjon.base.controller;

import lombok.AllArgsConstructor;
import uz.bakhromjon.base.service.BaseService;

@AllArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController {
    public S service;
}
