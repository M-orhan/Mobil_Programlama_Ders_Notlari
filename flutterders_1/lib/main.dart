import 'package:flutter/material.dart';

void main() {
  runApp(
    rowKullanim(),
  );
}

class body extends StatelessWidget {
  const body({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Mobil Sayfam'),
          backgroundColor: Colors.brown[700],
        ),
        body: Center(
          child: Text(
            'Merhaba Dünya',
            style: TextStyle(
              fontSize: 50,
              color: Colors.blueAccent,
              fontWeight: FontWeight.bold,
            ),
          ),
        ),
      ),
    );
  }
}

class resimGoster extends StatelessWidget {
  const resimGoster({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.brown,
        appBar: AppBar(
          title: Text('Resim'),
          backgroundColor: Colors.brown,
        ),
        body: Center(
          child: Image.asset("images/cicek.png"),
        ),
      ),
    );
  }
}

class containerOrnek extends StatelessWidget {
  const containerOrnek({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Container(
            width: 200,
            height: 300,
            alignment: Alignment.bottomRight,
            margin: EdgeInsets.symmetric(vertical: 250, horizontal: 100),
            padding: EdgeInsets.all(10.0),
            decoration: BoxDecoration(
              shape: BoxShape.rectangle,
              color: Colors.orange,
              borderRadius: BorderRadiusDirectional.circular(20.0),
            ),
            child: Text(
              'Merhaba',
              style: TextStyle(
                fontSize: 20,
                color: Colors.blue,
              ),
            ),
          ),
        ),
      ),
    );
  }
}

class columnKullanim extends StatelessWidget {
  const columnKullanim({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
          body: SafeArea(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.stretch,
              children: <Widget>[
                Container(
                  color: Colors.brown,
                  width: 150,
                  height: 75,
                  child: Text(
                    'Container 1',
                    style: TextStyle(color: Colors.white, fontSize: 25),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Container(
                  color: Colors.pinkAccent,
                  width: 150,
                  height: 75,
                  child: Text(
                    'Container 2',
                    style: TextStyle(color: Colors.white, fontSize: 25),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Container(
                  color: Colors.cyan[300],
                  width: 150,
                  height: 75,
                  child: Text(
                    'Container 3',
                    style: TextStyle(color: Colors.white, fontSize: 25),
                  ),
                ),
                SizedBox(
                  height: 20,
                ),
                Container(
                  color: Colors.indigo,
                  width: double.infinity,
                  height: 200,
                  child: Text(
                    'Container 4',
                    style: TextStyle(color: Colors.white, fontSize: 25),
                  ),
                ),
              ],
            ),
          ),
        ));
  }
}

class rowKullanim extends StatelessWidget {
  const rowKullanim({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: SafeArea(
          child: Row(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              Container(
                color: Colors.blueGrey,
                child: Text("Container 1"),
              ),
              SizedBox(width: 20,),
              Container(
                color: Colors.pink,
                child: Text("Container 2"),
              ),
              SizedBox(width: 30,),
              Container(
                color: Colors.cyanAccent,
                child: Text("Container 3"),
              ),
              SizedBox(width: 20,),
              Column( children: <Widget>[
                Container(
                  color: Colors.redAccent,
                  height: 200,
                  child: Text("Container 4"),
                ),
                SizedBox(height: 20,),
                Container(
                  color: Colors.teal,
                  height: 100,
                  child: Text("Container 5"),
                ),
              ],),
            ],
          ),
        ),
      ),
    );
  }
}
