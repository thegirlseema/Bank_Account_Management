import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ClientBalance } from './client-balance.component';


describe('ClientBalance', () => {
  let component: ClientBalance;
  let fixture: ComponentFixture<ClientBalance>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClientBalance ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientBalance);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
