import { ComponentFixture, TestBed } from '@angular/core/testing';
import { UpdateClient } from './update-client.component';


describe('UpdateClient', () => {
  let component: UpdateClient;
  let fixture: ComponentFixture<UpdateClient>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateClient ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateClient);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
