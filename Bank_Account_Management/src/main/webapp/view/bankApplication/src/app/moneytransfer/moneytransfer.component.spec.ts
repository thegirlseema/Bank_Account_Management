import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MoneyTransaction } from './moneytransfer.component';

describe('TransactionComponent', () => {
  let component: MoneyTransaction;
  let fixture: ComponentFixture<MoneyTransaction>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MoneyTransaction ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MoneyTransaction);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
