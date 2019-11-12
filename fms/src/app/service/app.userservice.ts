import {Injectable} from '@angular/core';
import {HttpClient,HttpParams, HttpHeaders} from '@angular/common/http';
import { routerNgProbeToken } from '@angular/router/src/router_module';
import { Router } from '@angular/router';
// import * as FileSaver from 'file-saver';
// import * as XLSX from 'xlsx';

const EXCEL_TYPE = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8';
const EXCEL_EXTENSION = '.xlsx';
@Injectable({
   providedIn:'root'
})

export class UserService{
  headers:any
  accountNo:any
  accountBalance:any
  phoneNumber:any

  constructor(private myhttp:HttpClient,private router:Router){

    this.headers = new HttpHeaders().set("Authorization",sessionStorage.getItem("token"));
   
  }

  getAmount(amount):any{
    let body = new HttpParams();
    body = body.set('amount', amount);
    
    return this.myhttp.post("http://13.233.48.144:9050/getAmount?",body,{headers:this.headers}
    );
}

transferAmount(phoneNo,amount):any{
  let body2 = new FormData();
  
  body2.append("phoneNo",phoneNo);
  body2.append("amount",amount);
  return this.myhttp.post("http://13.233.48.144:9050/transferAmount",body2,{headers:this.headers});
                                                                     
}
  
getTransactions(fromDate,toDate):any{

  alert("inside get transactions service "+toDate)
  let form = new HttpParams();
  form=form.set("fromDate",fromDate);
  form=form.set("toDate",toDate);
  return this.myhttp.post("http://13.233.48.144:9050/getTransactionsPage",form,{headers:this.headers});

}
getDbAccount(loginName):any{
  return this.myhttp.get("http://13.233.48.144:9050/getAccount?loginName="+loginName);
}
getAccountNo(){
  return this.accountNo
}
getAccountBalance(){
  return this.accountBalance
}
getPhoneNumber(){
  return this.phoneNumber
}

// public exportAsExcelFile(json: any[], excelFileName: string): void {
//   alert("excel")
//   const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(json);
//   const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
//   const excelBuffer: any = XLSX.write(workbook, { bookType: 'xlsx', type: 'array' });
//   this.saveAsExcelFile(excelBuffer, excelFileName);
// }
// public saveAsExcelFile(buffer: any, fileName: string): void {
//    const data: Blob = new Blob([buffer], {type: EXCEL_TYPE});
//    FileSaver.saveAs(data, fileName + '_export_' + new  Date().getTime() + EXCEL_EXTENSION);
// }
}





















































