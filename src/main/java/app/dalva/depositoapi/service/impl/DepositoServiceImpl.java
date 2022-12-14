package app.dalva.depositoapi.service.impl;

import org.springframework.stereotype.Service;

import app.dalva.depositoapi.model.converter.DepositoConverter;
import app.dalva.depositoapi.model.dto.DepositoDto;
import app.dalva.depositoapi.model.entity.DepositoEntity;
import app.dalva.depositoapi.model.request.DepositoRequest;
import app.dalva.depositoapi.model.response.DepositoDeleteResponse;
import app.dalva.depositoapi.model.response.DepositoListResponse;
import app.dalva.depositoapi.repository.DepositoRepository;
import app.dalva.depositoapi.service.DepositoService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepositoServiceImpl implements DepositoService {

    private final DepositoRepository repository;
    private final DepositoConverter depositoConverter;

    public DepositoServiceImpl(DepositoRepository repository, DepositoConverter depositoConverter) {
        this.repository = repository;
        this.depositoConverter = depositoConverter;
    }


    @Override
    public DepositoListResponse getdeposito(Long id) {
        final DepositoListResponse response = new DepositoListResponse();
        return repository.findById(id)
                .map(entity -> DepositoListResponse.builder().depositos(Collections.singletonList(depositoConverter.toDto(entity))).build())
                .orElse(response);
    }

    @Override
    public DepositoListResponse getAlldepositosFiltroCom(int com) {
        final List<DepositoEntity> entities = repository.findAll();

        final List<DepositoDto> converted = entities
                .stream()
                .map(depositoConverter::toDto).filter(s -> s.getComunicacao()==com)
                .collect(Collectors.toList());

        return DepositoListResponse.builder().depositos(converted).build();
    }
    @Override
    public DepositoListResponse getAlldepositosFiltroBody(String body) {
        final List<DepositoEntity> entities = repository.findAll();

        final List<DepositoDto> converted = entities
                .stream()
                .map(depositoConverter::toDto).filter(s -> s.getBody().contains(body))
                .collect(Collectors.toList());

        return DepositoListResponse.builder().depositos(converted).build();
    }

    @Override
    public DepositoListResponse getAlldepositos() {
        final List<DepositoEntity> entities = repository.findAll();

        final List<DepositoDto> converted = entities
                .stream()
                .map(depositoConverter::toDto)
                .collect(Collectors.toList());

        return DepositoListResponse.builder().depositos(converted).build();

    }

    @Override
    public DepositoDto createdeposito(DepositoRequest request) {
        final DepositoEntity saved = repository.save(depositoConverter.toEntity(request));
        return depositoConverter.toDto(saved);
    }

    @Override
    public DepositoDto updatedeposito(Long id, DepositoRequest request) {
        final Optional<DepositoEntity> optionaldepositoEntity = repository.findById(id);
        if (! optionaldepositoEntity.isPresent()) {
            return null;
        } else {
            final DepositoEntity toBeUpdated = depositoConverter.toEntity(request);
            toBeUpdated.setId(optionaldepositoEntity.get().getId());
            final DepositoEntity saved = repository.save(toBeUpdated);
            return depositoConverter.toDto(saved);
        }

    }

    @Override
    public DepositoDeleteResponse deletedeposito(Long id) {
        if (!repository.existsById(id)) {
            return DepositoDeleteResponse.builder().deleteddepositoCount(0L).build();
        } else {
            repository.deleteById(id);
            return DepositoDeleteResponse.builder().deleteddepositoCount(1L).build();
        }
    }


    @Override
    public DepositoDeleteResponse deleteAlldepositos() {
        final long count = repository.count();
        if (count == 0) {
            return DepositoDeleteResponse.builder().deleteddepositoCount(0L).build();
        } else {
            repository.deleteAll();
            return DepositoDeleteResponse.builder().deleteddepositoCount(count).build();
        }
    }

    @Override
    public DepositoDeleteResponse deleteAlldepositosFiltroBody(String body) {


        final List<DepositoEntity> entities = repository.findAll();

        var filter = entities
                        .stream()
                        .filter(s -> s.getBody().contains(body))
                        .collect(Collectors.toList());

                
        final long count = filter.size();
        if (count == 0) {
            return DepositoDeleteResponse.builder().deleteddepositoCount(0L).build();
        } else {
            repository.deleteAll(filter);
            return DepositoDeleteResponse.builder().deleteddepositoCount(count).build();
        }
    }


}

