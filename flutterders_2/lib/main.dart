import 'dart:math';

import 'package:flutter/material.dart';

void main() {
  runApp((ekran()));
}

class ozelFont extends StatelessWidget {
  const ozelFont({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(fontFamily: 'Alkatra'),
      home: Scaffold(
        body: SafeArea(
          child: Text(
            'Merhaba Dünya',
            style: TextStyle(fontFamily: 'Alkatra', fontSize: 50),
          ),
        ),
      ),
    );
  }
}

class rastgeleSayiUret extends StatelessWidget {
  const rastgeleSayiUret({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.purple,
          title: Text(
            'Rastgele Sayı Üret',
            style: TextStyle(
                color: Colors.white, fontSize: 25, fontFamily: 'Alkatra'),
          ),
        ),
        body: rasgele(),
      ),
    );
  }
}

class rasgele extends StatefulWidget {
  const rasgele({super.key});

  @override
  State<rasgele> createState() => _rasgeleState();
}

class _rasgeleState extends State<rasgele> {
  int uretilenSayi = 0;

  void sayiUret() {
    setState(() {
      uretilenSayi = Random().nextInt(100);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Center(
      child: Column(
        children: <Widget>[
          Padding(
            padding: const EdgeInsets.all(20.0),
            child: TextButton(
              style: ButtonStyle(
                backgroundColor: MaterialStateProperty.all(Colors.black),
              ),
              onPressed: sayiUret,
              child: Text(
                'Sayı Üret',
                style: TextStyle(fontSize: 30, color: Colors.white),
              ),
            ),
          ),
          Text(
            '$uretilenSayi',
            style: TextStyle(fontSize: 150, fontWeight: FontWeight.bold),
          )
        ],
      ),
    );
  }
}

class ekran extends StatelessWidget {
  const ekran({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Buton Rengi Değiştir'),
        ),
        body: ekranIslem(),
      ),
    );
  }
}

class ekranIslem extends StatefulWidget {
  const ekranIslem({super.key});

  @override
  State<ekranIslem> createState() => _ekranIslemState();
}

class _ekranIslemState extends State<ekranIslem> {
  String secilenButon = 'SOL';

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: const EdgeInsets.all(50.0),
      child: Center(
        child: Row(
          children: <Widget>[
            TextButton(
                onPressed: () {
                  setState(() {
                    secilenButon = 'SOL';
                  });
                },
                child: Container(
                    width: 150,
                    height: 300,
                    color: secilenButon == 'SOL'
                        ? Colors.lightBlueAccent
                        : Colors.blueGrey)),
            TextButton(
                onPressed: () {
                  setState(() {
                    secilenButon = 'SAĞ';
                  });
                },
                child: Container(
                    width: 150,
                    height: 300,
                    color: secilenButon == 'SAĞ'
                        ? Colors.lightBlueAccent
                        : Colors.blueGrey))
          ],
        ),
      ),
    );
  }
}
