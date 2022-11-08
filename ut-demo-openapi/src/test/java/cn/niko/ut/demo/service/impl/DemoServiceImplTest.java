package cn.niko.ut.demo.service.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import cn.niko.ut.demo.service.LogicService;
import cn.niko.ut.demo.service.PersistenceService;

import static org.junit.Assert.*;

/**
 * @author yongqi.pan
 * @since 2022/11/7 16:43
 */
@RunWith(MockitoJUnitRunner.class)
public class DemoServiceImplTest {

    @InjectMocks
    private DemoServiceImpl categoryService;

    @Mock
    private PersistenceService persistenceService;

    @Mock
    private LogicService logicService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private final String applicationName = "ut-demo";

    @Before
    public void setUp() throws Exception {
        ReflectionTestUtils.setField(categoryService, "applicationName", applicationName);
    }

    @Test
    public void testVerifyTimes(){
        String categoryByName = categoryService.getStringByName(applicationName);
        Mockito.when(logicService.doLogic(applicationName)).thenReturn("Done");
        Mockito.doNothing().when(persistenceService).insert();
        Mockito.verify(persistenceService, new Times(1)).insert();
        assertEquals(applicationName, categoryByName);
    }

    @Test
    public void testException(){
        Mockito.doThrow(new RuntimeException()).when(persistenceService).insert();
        thrown.expectMessage("exception");
        thrown.expect(RuntimeException.class);
        categoryService.getStringByName(applicationName);
    }
}