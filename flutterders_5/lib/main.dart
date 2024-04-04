import 'package:flutter/material.dart';

void main() {
  runApp(dataWidgets());
}

class dataWidgets extends StatefulWidget {
  const dataWidgets({super.key});

  @override
  State<dataWidgets> createState() => _dataWidgetsState();
}

class _dataWidgetsState extends State<dataWidgets> {

  int secilenSayfaIndexi = 0;
  String yazi = "";
  TextEditingController fieldController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.white,
        appBar: AppBar(
          backgroundColor: Colors.deepPurple,
          title: const Text('Başlık'),
        ),
        body: Column(
          children: [
            TextField(
              controller: fieldController,
              style: TextStyle(color: Colors.black),
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                contentPadding: EdgeInsets.all(10),
                hintText: 'Birşeyler yazın',
                filled: true,
                fillColor: Colors.black12,
              ),
              autofocus: true,
              cursorColor: Colors.black12,
            ),
            ElevatedButton(
              onPressed: () {
                setState(() {
                  yazi = fieldController.text;
                });
              },
              child: Text("Aktar"),
            ),
            Text(yazi, style: TextStyle(fontSize: 30),),
          ],
        ),
        bottomNavigationBar: alttakiWidgetim(),
      ),
    );
  }


  Widget alttakiWidgetim() {
    return BottomNavigationBar(
      items: [
        BottomNavigationBarItem(
            icon: Icon(Icons.add_a_photo_outlined), label: 'Kamera'),
        BottomNavigationBarItem(icon: Icon(Icons.add_alarm), label: 'Alarm'),
        BottomNavigationBarItem(icon: Icon(Icons.add_call), label: 'Arama'),
      ],
      elevation: 20,
      currentIndex: secilenSayfaIndexi,
      onTap: sayfaDegistir,
      backgroundColor: Colors.grey,
      selectedItemColor: Colors.grey[900],
      unselectedItemColor: Colors.grey,
      iconSize: 25,
      showSelectedLabels: true,
      showUnselectedLabels: true,
      unselectedFontSize: 12,
      selectedFontSize: 16,
      type: BottomNavigationBarType.shifting,
    );
  }

  void sayfaDegistir(int yeniIndex) {
    setState(() {
      secilenSayfaIndexi = yeniIndex;
    });
  }
}
