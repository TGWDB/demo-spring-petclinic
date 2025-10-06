package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {PetTypeRepository.class})
@DataJpaTest
@EnableAutoConfiguration
@EntityScan(basePackages = {"org.springframework.samples.petclinic.owner"})
class PetTypeRepositoryDiffblueTest {
  @Autowired private PetTypeRepository petTypeRepository;

  /**
   * Test {@link PetTypeRepository#findPetTypes()}.
   *
   * <p>Method under test: {@link PetTypeRepository#findPetTypes()}
   */
  @Test
  @DisplayName("Test findPetTypes()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.findPetTypes()"})
  void testFindPetTypes() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act
    List<PetType> actualFindPetTypesResult = petTypeRepository.findPetTypes();

    // Assert
    assertEquals(8, actualFindPetTypesResult.size());
    assertSame(petType2, actualFindPetTypesResult.get(0));
    assertSame(petType, actualFindPetTypesResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#count()}.
   *
   * <p>Method under test: {@link PetTypeRepository#count()}
   */
  @Test
  @DisplayName("Test count()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PetTypeRepository.count()"})
  void testCount() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act and Assert
    assertEquals(8L, petTypeRepository.count());
  }

  /**
   * Test {@link PetTypeRepository#count(Example)} with {@code Example}.
   *
   * <p>Method under test: {@link PetTypeRepository#count(Example)}
   */
  @Test
  @DisplayName("Test count(Example) with 'Example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long PetTypeRepository.count(Example)"})
  void testCountWithExample() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act and Assert
    assertEquals(1L, petTypeRepository.count(example));
  }

  /**
   * Test {@link PetTypeRepository#delete(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#delete(Object)}
   */
  @Test
  @DisplayName("Test delete(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.delete(Object)"})
  void testDelete() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);
    petTypeRepository.save(petType3);

    // Act
    petTypeRepository.delete(petType3);

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#deleteAllById(Iterable)}.
   *
   * <p>Method under test: {@link PetTypeRepository#deleteAllById(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.deleteAllById(Iterable)"})
  void testDeleteAllById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    PetType petType4 = new PetType();
    petType4.setName("Dog");

    PetType petType5 = new PetType();
    petType5.setName("Dog");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);
    petTypeRepository.save(petType3);
    petTypeRepository.save(petType4);
    petTypeRepository.save(petType5);
    List<Integer> ids = Arrays.asList(petType3.getId(), petType4.getId(), petType5.getId());

    // Act
    petTypeRepository.deleteAllById(ids);

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#deleteAllByIdInBatch(Iterable)}.
   *
   * <p>Method under test: {@link PetTypeRepository#deleteAllByIdInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllByIdInBatch(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.deleteAllByIdInBatch(Iterable)"})
  void testDeleteAllByIdInBatch() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act
    petTypeRepository.deleteAllByIdInBatch(new ArrayList<>());

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#deleteAllInBatch(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link PetTypeRepository#deleteAllInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAllInBatch(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.deleteAllInBatch(Iterable)"})
  void testDeleteAllInBatchWithIterable() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    PetType petType4 = new PetType();
    petType4.setName("Dog");

    PetType petType5 = new PetType();
    petType5.setName("Dog");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);
    petTypeRepository.save(petType3);
    petTypeRepository.save(petType4);
    petTypeRepository.save(petType5);

    List<PetType> entities = Arrays.asList(petType3, petType4, petType5);

    // Act
    petTypeRepository.deleteAllInBatch(entities);

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#deleteAll(Iterable)} with {@code Iterable}.
   *
   * <p>Method under test: {@link PetTypeRepository#deleteAll(Iterable)}
   */
  @Test
  @DisplayName("Test deleteAll(Iterable) with 'Iterable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.deleteAll(Iterable)"})
  void testDeleteAllWithIterable() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    PetType petType4 = new PetType();
    petType4.setName("Dog");

    PetType petType5 = new PetType();
    petType5.setName("Dog");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);
    petTypeRepository.save(petType3);
    petTypeRepository.save(petType4);
    petTypeRepository.save(petType5);

    List<PetType> entities = Arrays.asList(petType3, petType4, petType5);

    // Act
    petTypeRepository.deleteAll(entities);

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#deleteById(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#deleteById(Object)}
   */
  @Test
  @DisplayName("Test deleteById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.deleteById(Object)"})
  void testDeleteById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");
    petTypeRepository.save(petType);

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    petTypeRepository.save(petType3);

    // Act
    petTypeRepository.deleteById(petType3.getId());

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#deleteInBatch(Iterable)}.
   *
   * <p>Method under test: {@link PetTypeRepository#deleteInBatch(Iterable)}
   */
  @Test
  @DisplayName("Test deleteInBatch(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.deleteInBatch(Iterable)"})
  void testDeleteInBatch() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    PetType petType4 = new PetType();
    petType4.setName("Dog");

    PetType petType5 = new PetType();
    petType5.setName("Dog");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);
    petTypeRepository.save(petType3);
    petTypeRepository.save(petType4);
    petTypeRepository.save(petType5);

    List<PetType> entities = Arrays.asList(petType3, petType4, petType5);

    // Act
    petTypeRepository.deleteInBatch(entities);

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#existsById(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#existsById(Object)}
   */
  @Test
  @DisplayName("Test existsById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PetTypeRepository.existsById(Object)"})
  void testExistsById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");
    petTypeRepository.save(petType);

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    petTypeRepository.save(petType3);

    // Act and Assert
    assertTrue(petTypeRepository.existsById(petType3.getId()));
  }

  /**
   * Test {@link PetTypeRepository#exists(Example)}.
   *
   * <ul>
   *   <li>Given {@link PetType} (default constructor) Name is {@code Dog}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link PetTypeRepository#exists(Example)}
   */
  @Test
  @DisplayName(
      "Test exists(Example); given PetType (default constructor) Name is 'Dog'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PetTypeRepository.exists(Example)"})
  void testExists_givenPetTypeNameIsDog_thenReturnTrue() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act and Assert
    assertTrue(petTypeRepository.exists(example));
  }

  /**
   * Test {@link PetTypeRepository#exists(Example)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link PetTypeRepository#exists(Example)}
   */
  @Test
  @DisplayName("Test exists(Example); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean PetTypeRepository.exists(Example)"})
  void testExists_thenReturnFalse() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Bella");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act and Assert
    assertFalse(petTypeRepository.exists(example));
  }

  /**
   * Test {@link PetTypeRepository#findAll()}.
   *
   * <p>Method under test: {@link PetTypeRepository#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.findAll()"})
  void testFindAll() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act
    List<PetType> actualFindAllResult = petTypeRepository.findAll();

    // Assert
    assertEquals(8, actualFindAllResult.size());
    assertSame(petType2, actualFindAllResult.get(0));
    assertSame(petType, actualFindAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#findAllById(Iterable)}.
   *
   * <p>Method under test: {@link PetTypeRepository#findAllById(Iterable)}
   */
  @Test
  @DisplayName("Test findAllById(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.findAllById(Iterable)"})
  void testFindAllById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    PetType petType4 = new PetType();
    petType4.setName("Dog");

    PetType petType5 = new PetType();
    petType5.setName("Dog");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);
    petTypeRepository.save(petType3);
    petTypeRepository.save(petType4);
    petTypeRepository.save(petType5);
    List<Integer> ids = Arrays.asList(petType3.getId(), petType4.getId(), petType5.getId());

    // Act
    List<PetType> actualFindAllByIdResult = petTypeRepository.findAllById(ids);

    // Assert
    assertEquals(3, actualFindAllByIdResult.size());
    assertSame(petType3, actualFindAllByIdResult.get(0));
    assertSame(petType4, actualFindAllByIdResult.get(1));
    assertSame(petType5, actualFindAllByIdResult.get(2));
  }

  /**
   * Test {@link PetTypeRepository#findAll(Example)} with {@code example}.
   *
   * <p>Method under test: {@link PetTypeRepository#findAll(Example)}
   */
  @Test
  @DisplayName("Test findAll(Example) with 'example'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.findAll(Example)"})
  void testFindAllWithExample() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act
    List<PetType> actualFindAllResult = petTypeRepository.findAll(example);

    // Assert
    assertEquals(1, actualFindAllResult.size());
    assertSame(petType, actualFindAllResult.get(0));
  }

  /**
   * Test {@link PetTypeRepository#findAll(Example, Pageable)} with {@code example}, {@code
   * pageable}.
   *
   * <p>Method under test: {@link PetTypeRepository#findAll(Example, Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Example, Pageable) with 'example', 'pageable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page PetTypeRepository.findAll(Example, Pageable)"})
  void testFindAllWithExamplePageable() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act
    Page<PetType> actualFindAllResult = petTypeRepository.findAll(example, Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<PetType> toListResult = actualFindAllResult.toList();
    assertEquals(1, toListResult.size());
    assertSame(petType, toListResult.get(0));
  }

  /**
   * Test {@link PetTypeRepository#findAll(Example, Sort)} with {@code example}, {@code sort}.
   *
   * <ul>
   *   <li>Given {@link PetType} (default constructor) Name is {@code Dog}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link PetTypeRepository#findAll(Example, Sort)}
   */
  @Test
  @DisplayName(
      "Test findAll(Example, Sort) with 'example', 'sort'; given PetType (default constructor) Name is 'Dog'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.findAll(Example, Sort)"})
  void testFindAllWithExampleSort_givenPetTypeNameIsDog_thenReturnSizeIsOne() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act
    List<PetType> actualFindAllResult = petTypeRepository.findAll(example, Sort.unsorted());

    // Assert
    assertEquals(1, actualFindAllResult.size());
    assertSame(petType, actualFindAllResult.get(0));
  }

  /**
   * Test {@link PetTypeRepository#findAll(Pageable)} with {@code pageable}.
   *
   * <p>Method under test: {@link PetTypeRepository#findAll(Pageable)}
   */
  @Test
  @DisplayName("Test findAll(Pageable) with 'pageable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Page PetTypeRepository.findAll(Pageable)"})
  void testFindAllWithPageable() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act
    Page<PetType> actualFindAllResult = petTypeRepository.findAll(Pageable.unpaged());

    // Assert
    assertTrue(actualFindAllResult instanceof PageImpl);
    List<PetType> toListResult = actualFindAllResult.toList();
    assertEquals(8, toListResult.size());
    assertSame(petType2, toListResult.get(0));
    assertSame(petType, toListResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#findAll(Sort)} with {@code sort}.
   *
   * <ul>
   *   <li>When unsorted.
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link PetTypeRepository#findAll(Sort)}
   */
  @Test
  @DisplayName("Test findAll(Sort) with 'sort'; when unsorted; then return size is eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.findAll(Sort)"})
  void testFindAllWithSort_whenUnsorted_thenReturnSizeIsEight() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act
    List<PetType> actualFindAllResult = petTypeRepository.findAll(Sort.unsorted());

    // Assert
    assertEquals(8, actualFindAllResult.size());
    assertSame(petType2, actualFindAllResult.get(0));
    assertSame(petType, actualFindAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#findById(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#findById(Object)}
   */
  @Test
  @DisplayName("Test findById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PetTypeRepository.findById(Object)"})
  void testFindById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");
    petTypeRepository.save(petType);

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    petTypeRepository.save(petType3);

    // Act
    Optional<PetType> actualFindByIdResult = petTypeRepository.findById(petType3.getId());

    // Assert
    assertTrue(actualFindByIdResult.isPresent());
    assertSame(petType3, actualFindByIdResult.get());
  }

  /**
   * Test {@link PetTypeRepository#findOne(Example)}.
   *
   * <p>Method under test: {@link PetTypeRepository#findOne(Example)}
   */
  @Test
  @DisplayName("Test findOne(Example)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional PetTypeRepository.findOne(Example)"})
  void testFindOne() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    Example<PetType> example = Example.of(petType3);

    // Act
    Optional<PetType> actualFindOneResult = petTypeRepository.findOne(example);

    // Assert
    assertTrue(actualFindOneResult.isPresent());
    assertSame(petType, actualFindOneResult.get());
  }

  /**
   * Test {@link PetTypeRepository#flush()}.
   *
   * <p>Method under test: {@link PetTypeRepository#flush()}
   */
  @Test
  @DisplayName("Test flush()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void PetTypeRepository.flush()"})
  void testFlush() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType);
    petTypeRepository.save(petType2);

    // Act
    petTypeRepository.flush();

    // Assert
    List<PetType> findAllResult = petTypeRepository.findAll();
    assertEquals(8, findAllResult.size());
    assertSame(petType2, findAllResult.get(0));
    assertSame(petType, findAllResult.get(1));
  }

  /**
   * Test {@link PetTypeRepository#getById(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#getById(Object)}
   */
  @Test
  @DisplayName("Test getById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PetTypeRepository.getById(Object)"})
  void testGetById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");
    petTypeRepository.save(petType);

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    petTypeRepository.save(petType3);

    // Act and Assert
    assertSame(petType3, petTypeRepository.getById(petType3.getId()));
  }

  /**
   * Test {@link PetTypeRepository#getReferenceById(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#getReferenceById(Object)}
   */
  @Test
  @DisplayName("Test getReferenceById(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PetTypeRepository.getReferenceById(Object)"})
  void testGetReferenceById() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");
    petTypeRepository.save(petType);

    PetType petType2 = new PetType();
    petType2.setName("Bella");
    petTypeRepository.save(petType2);

    PetType petType3 = new PetType();
    petType3.setName("Dog");
    petTypeRepository.save(petType3);

    // Act and Assert
    assertSame(petType3, petTypeRepository.getReferenceById(petType3.getId()));
  }

  /**
   * Test {@link PetTypeRepository#save(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#save(Object)}
   */
  @Test
  @DisplayName("Test save(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PetTypeRepository.save(Object)"})
  void testSave() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    // Act
    PetType actualSaveResult = petTypeRepository.save(petType);

    // Assert
    assertSame(petType, actualSaveResult);
  }

  /**
   * Test {@link PetTypeRepository#saveAll(Iterable)}.
   *
   * <p>Method under test: {@link PetTypeRepository#saveAll(Iterable)}
   */
  @Test
  @DisplayName("Test saveAll(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.saveAll(Iterable)"})
  void testSaveAll() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Dog");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    List<PetType> entities = Arrays.asList(petType, petType2, petType3);

    // Act
    List<PetType> actualSaveAllResult = petTypeRepository.saveAll(entities);

    // Assert
    assertEquals(entities, actualSaveAllResult);
  }

  /**
   * Test {@link PetTypeRepository#saveAllAndFlush(Iterable)}.
   *
   * <p>Method under test: {@link PetTypeRepository#saveAllAndFlush(Iterable)}
   */
  @Test
  @DisplayName("Test saveAllAndFlush(Iterable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List PetTypeRepository.saveAllAndFlush(Iterable)"})
  void testSaveAllAndFlush() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    PetType petType2 = new PetType();
    petType2.setName("Dog");

    PetType petType3 = new PetType();
    petType3.setName("Dog");

    List<PetType> entities = Arrays.asList(petType, petType2, petType3);

    // Act
    List<PetType> actualSaveAllAndFlushResult = petTypeRepository.saveAllAndFlush(entities);

    // Assert
    assertEquals(entities, actualSaveAllAndFlushResult);
  }

  /**
   * Test {@link PetTypeRepository#saveAndFlush(Object)}.
   *
   * <p>Method under test: {@link PetTypeRepository#saveAndFlush(Object)}
   */
  @Test
  @DisplayName("Test saveAndFlush(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object PetTypeRepository.saveAndFlush(Object)"})
  void testSaveAndFlush() {
    // Arrange
    PetType petType = new PetType();
    petType.setName("Dog");

    // Act
    PetType actualSaveAndFlushResult = petTypeRepository.saveAndFlush(petType);

    // Assert
    assertSame(petType, actualSaveAndFlushResult);
  }
}
