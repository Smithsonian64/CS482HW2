/*
 Michael Smith
 10/2/2020
 Homework 2
 */

/*1*/
SELECT DISTINCT
    S.modelNo
FROM
    Specializes AS S,
    TechnicalSupport AS T
WHERE
        S.empId = T.empId AND
        T.name = 'Tom';

/*2*/
SELECT T.name,
       T.empId
FROM
    TechnicalSupport AS T,
    DigitalDisplay AS D,
    Locates AS L,
    Specializes AS S
WHERE D.modelNo = 'M01' AND
        D.serialNo = L.serialNo AND
        L.siteCode = 111 AND
        S.modelNo = 'M01' AND
        T.empId = S.empId;

/*3*/
SELECT
    T.empId,
    T.name
FROM
    TechnicalSupport AS T,
    DigitalDisplay AS D,
    Specializes AS S
WHERE
        D.schedulerSystem = 'Random' AND
        S.modelNo = D.modelNo AND
        S.empId = T.empId;

/*4*/
SELECT *
FROM Administrator AS A
UNION
SELECT *
FROM Salesman AS S
UNION
SELECT *
FROM TechnicalSupport AS T;

/*5*/
SELECT
       V.videoLength,
       V.videoCode
FROM
     Video AS V,
     Broadcasts AS B
WHERE
      B.videoCode = V.videoCode AND
      B.siteCode = 111;

/*6*/
SELECT
       empId,
       COUNT(*) AS C
FROM Administers
GROUP BY empId
HAVING C > 10;

/*7*/
SELECT MAX(V.videoLength)
FROM
     Video AS V,
     Broadcasts AS B
WHERE
      V.videoCode = B.videoCode AND
      B.siteCode = 111;

/*8*/
SELECT
       V.videoCode,
       V.videoLength,
       MAX(V.videoLength)
FROM
    Video AS V,
    Broadcasts AS B
WHERE
        V.videoCode = B.videoCode AND
        B.siteCode = 112;

/*9*/
SELECT
    AD.empId,
    A.name,
    A.gender,
    COUNT(*) AS C
FROM Administers AS AD,
     Administrator AS A
WHERE AD.empId = A.empId
GROUP BY AD.empId
HAVING C < 10;

/*10*/
SELECT
       MAX(P.commissionRate),
       S.empId,
       S.name
FROM
     Salesman AS S,
     Purchases AS P
WHERE P.empId = S.empId;

/*11*/
SELECT DISTINCT
       S.empId,
       S.name,
       COUNT(S.empId = P.empId) AS C,
       COUNT(S2.empId = P.empId) AS C2
FROM
     Purchases AS P,
     Salesman AS S,
     Salesman AS S2
GROUP BY S.empId, S2.empId
HAVING C > C2;


/*12*/
SELECT DISTINCT
       T.empId,
       T.name,
       T.gender
FROM
     TechnicalSupport AS T,
     TechnicalSupport AS T2,
     Specializes AS S
WHERE
      T2.name = 'Tom' AND
      S.empId = T2.empId AND
      S.empId = T.empId



