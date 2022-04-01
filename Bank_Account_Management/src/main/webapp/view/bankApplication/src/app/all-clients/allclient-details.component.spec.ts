import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AllClients } from './allclient-details.component';


describe('AllClients', () => {
  let component: AllClients;
  let fixture: ComponentFixture<AllClients>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllClients ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllClients);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
