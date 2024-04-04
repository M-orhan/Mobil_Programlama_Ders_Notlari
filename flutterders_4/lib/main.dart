import 'package:flutter/material.dart';


void main() {
  runApp(dataWidgets());
}

class dataWidgets extends StatelessWidget {
  const dataWidgets({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Widgetlar'),
          backgroundColor: Colors.cyan,
        ),
        body: /*dataWidgetBody(),*/ /*_checkBoxWidgetiState(),*/ radioWidgeti(),
        endDrawer:  _buildDrawer(context),
        //Text('Merhaba Dünya',style: TextStyle(fontSize: 40),),
      ),
    );
  }
}

class dataWidgetBody extends StatefulWidget {
  const dataWidgetBody({super.key});

  @override
  State<dataWidgetBody> createState() => _dataWidgetBodyState();
}

class _dataWidgetBodyState extends State<dataWidgetBody> {

  bool durum = false;

  void durumDegistir(bool yeniDurum) {
    setState(() {
      durum = yeniDurum;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Switch(
          activeColor: Colors.pink,
          inactiveThumbColor: Colors.black,
          activeTrackColor: Colors.lightBlue,
          inactiveTrackColor: Colors.brown,
          value: durum,
          onChanged: durumDegistir,
        ),
        SizedBox(height: 10,),
        Text('Switch in durumu: $durum',
          style: TextStyle(fontSize: 25),
        )
      ],
    );
  }

}

class _checkBoxWidgetiState extends StatefulWidget {
  const _checkBoxWidgetiState({super.key});

  @override
  State<_checkBoxWidgetiState> createState() => _checkBoxWidgetiStateState();
}

class _checkBoxWidgetiStateState extends State<_checkBoxWidgetiState> {

  bool java = false,
      cSharp = false,
      php = false;

  String bilinenDiller() {
    String diller = "";
    if (java == true) diller += "Java ";
    if (cSharp == true) diller += "CSharp ";
    if (php == true) diller += "Php ";
    return diller;
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
      Text('Bildiğiniz programlama dilleri:', style: TextStyle(fontSize: 25),
    ),
    CheckboxListTile(
    title: Text("Java",
    style: TextStyle(fontSize: 25),
    ),
    value: java,
    onChanged: (bool? newValue){
    setState(()
    {
    java=newValue!;
    });
    },
    ),
        SizedBox(
          height: 20,
        ),
        CheckboxListTile(
          title: Text(
            "Csharp",
            style: TextStyle(fontSize: 25),
          ),
          value: cSharp,
          onChanged: (bool? newValue) {
            setState(() {
              cSharp = newValue!;
            });
          },
        ),
        SizedBox(height: 20,),
        CheckboxListTile(
          title: Text(
            "Php",
            style: TextStyle(fontSize: 25),
          ),
          value: php,
          onChanged: (bool? newValue) {
            setState(() {
              php = newValue!;
            });
          },
        ),
        Text('Diller : '+bilinenDiller(), style: TextStyle(fontSize: 25),),
      ],
    );
  }
}

class radioWidgeti extends StatefulWidget {
  const radioWidgeti({super.key});

  @override
  State<radioWidgeti> createState() => _radioWidgetiState();
}

class _radioWidgetiState extends State<radioWidgeti> {

  String secilenTakim="";
  void secilenTakimDegistir(String? yeniTakim) {
    setState(() {
      secilenTakim=yeniTakim!;
    });
  }
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: [
          Text('Hangi takımı tutuyorsunuz', style: TextStyle(fontSize: 25)
          ),
          RadioListTile(
            title: Text('Fenerbahçe',
      style: TextStyle(fontSize: 25),
          ),
      value: 'Fenerbahçe',
      groupValue: secilenTakim,
      onChanged: secilenTakimDegistir,
      activeColor: Colors.blue[800],
          ),

          RadioListTile(
            title: Text('Beşiktaş',
              style: TextStyle(fontSize: 25),
            ),
            value: 'Beşiktaş',
            groupValue: secilenTakim,
            onChanged: secilenTakimDegistir,
            activeColor: Colors.black,
          ),
          RadioListTile(
            title: Text('Galatasaray',
              style: TextStyle(fontSize: 25),
            ),
            value: 'Galatasaray',
            groupValue: secilenTakim,
            onChanged: secilenTakimDegistir,
            activeColor: Colors.deepOrange,
          ),
          RadioListTile(
            title: Text('Trabzonspor',
              style: TextStyle(fontSize: 25),
            ),
            value: 'Trabzonspor',
            groupValue: secilenTakim,
            onChanged: secilenTakimDegistir,
            activeColor: Colors.deepPurple,
          ),
          Text('Seçilen takım: $secilenTakim',style: TextStyle(fontSize: 25),)
        ],
      ),
    );



  }
}

Widget _buildDrawer(BuildContext context)
{
  return Drawer(
    child: ListView(
      children: [
        UserAccountsDrawerHeader(
          currentAccountPicture: FlutterLogo(),
          accountName: Text('Mert Orhan',style: TextStyle(fontSize: 25),),
          accountEmail: Text('orhan.mertcan@gmail.com'),
          decoration: BoxDecoration(color: Colors.deepPurple),
        ),
        ListTile(
          leading: Icon(Icons.book,color: Colors.deepPurple),
          title: Text('Kitaplar',style: TextStyle(fontSize: 25,fontWeight: FontWeight.bold),),
          subtitle: Text('Detaylar için tıklayın',style: TextStyle(fontFamily: 'fonts/Ubuntu-Italic'),),
          /*trailing: Icon(Icons.book,color: Colors.deepPurple),*/
          onTap: (){
            Navigator.pop(context);
          },
        ),
        ListTile(
          leading: Icon(Icons.book_online,color: Colors.deepPurple),
          title: Text('Makaleler',style: TextStyle(fontSize: 25,fontWeight: FontWeight.bold)),
          subtitle: Text('Detaylar için tıklayın'),
          onTap: (){
            Navigator.pop(context);
          },
        ),
      ],
    ),
  );

}







