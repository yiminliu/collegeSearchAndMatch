DROP TABLE IF EXISTS school_names;
CREATE TABLE school_names
(
  School_Id INT NOT NULL,
  English_Name VARCHAR(80),
  Chinese_Name VARCHAR(80),
  Primary Key (School_Id),
  FOREIGN KEY (School_Id) REFERENCES school (Id)
);

Insert school_names(id, english_name, chinese_name) values
(1,	Princeton University,
(2,	Harvard University,
(3,	Yale University,
(4,	Stanford University,
(5,	University of Pennsylvania,
(6,	California Institute of Technology,
(7,	Massachusetts Institute of Technology,
(8,	Duke University,
(9,	Columbia University,
(10, University of Chicago,
(11, Dartmouth College,
(12, Washington University in St. Louis,
(13, Cornell University,
(14, Brown University,
(15, Northwestern University,
16,	Johns Hopkins University,
17,	Rice University,
18,	Emory University,
19,	Vanderbilt University,
20,	University of Notre Dame,
21,	University of California-Berkeley,
22,	Carnegie Mellon University,
23,	University of Virginia,
24,	Georgetown University,
25,	University of California-Los Angeles,
26,	University of Michigan-Ann Arbor,
27,	University of Southern California,
28,	University of North Carolina-Chapel Hill,
29,	Tufts University,
30,	Wake Forest University,
31,	Lehigh University,
32,	Brandeis University,
33,	College of William and Mary,
34,	New York University,
35,	University of Rochester,
36,	Georgia Institute of Technology,
37,	Boston College,
38,	University of Wisconsin-Madison,
39,	University of California-San Diego,
40,	University of Illinois-Urbana-Champaign,
41,	Case Western Reserve University,
42,	University of Washington,
43,	University of California-Davis,
44,	Rensselaer Polytechnic Institute,
45,	University of Texas-Austin,
46,	University of California-Santa Barbara,
47,	University of California-Irvine,
48,	Pennsylvania State University-University Park,
49,	University of Florida,
50,	Tulane University,
51,	Syracuse University,
52,	University of Miami,
53,	Yeshiva University,
54,	George Washington University,
55,	Pepperdine University,
56,	University of Maryland-College Park,
57,	Boston University,
58,	Ohio State University-Columbus,
59,	Rutgers, the State University of New Jersey-New Brunswick,
60,	University of Georgia,
61,	University of Pittsburgh,
62,	Texas A&M University-College Station,
63,	Worcester Polytechnic Institute,
64,	University of Iowa,
65,	University of Connecticut,
66,	Purdue University-West Lafayette,
67,	Southern Methodist University,
68,	Clemson University,
69,	Fordham University,
70,	Miami University-Oxford,
71,	Virginia Tech,
72,	Michigan State University,
73,	University of Delaware,
74,	University of Minnesota-Twin Cities,
75,	Indiana University-Bloomington,
76,	Baylor University,
77,	Stevens Institute of Technology,
78,	Colorado School of Mines,
79,	Brigham Young University-Provo,
80,	University of Colorado-Boulder,
81,	University of California-Santa Cruz,
82,	SUNY-Binghamton,
83,	Saint Louis University,
84,	Marquette University,
85,	University of Kansas,
86,	Iowa State University,
87,	American University,
88,	University of Denver,
89,	North Carolina State University-Raleigh,
90,	SUNY College of Environmental Science and Forestry,
91,	Clark University,
92,	University of Missouri-Columbia,
93,	University of Alabama,
94,	University of Tulsa,
95,	University of Nebraska-Lincon,
96,	University of Massachusetts-Amherst,
97,	Northeastern University,
98,	University of Vermont,
99,	SUNY-Stony Brook,
100,	Illinois Institute of Technology,
101,	University of Tennessee,
102,	Howard University,
103,	University of California-Riverside,
104,	University of the Pacific,
105,	University of Arizona,
106,	University of San Diego,
107,	Texas Christian University,
108,	Drexel University,
109,	University of New Hampshire,
110,	University of Oklahoma,
111,Loyola University of Chicago,
112,	Florida State University,
113,	University of South Carolina,
114,	University of Oregon,
115,	University of Dayton,
116,	Ohio University,
117	Missouri University of Science & Technology,
118	University at Buffalo-SUNY,
119	Washington State University,
120	University of Kentucky,
121	Cathodtc University of America,
122	New Jersey Institute of Technology,
123	Kansas State University,
124	Clarkson University,
125	Colorado State University,
126	University of Arkansas-Fayetteville,
127	Arizona State University-Tempe,
128	Michigan Technological University,
129	Temple University,
130	Duquesne University,
131	University of St. Thomas,
132	University of Utah,
133	DePaul University,
134	Seton Hall University,
135	New School,
136	University of Illinois-Chicago,
137	University at Albany-SUNY,
138	Louisiana State University-Baton Rouge,
139	George Mason University,
140	Hofstra University,
141	University of San Francisco,
142	Auburn University,
143	Oregon State University,
144	Rutgers, The State University of New Jersey-Newark,
145	University of Cincinnati,
146	University of Mississippi,
147	University of Texas-Dallas,
148	St. John Fisher College,
149	Illinois State University,
150	Oklahoma State University,
151	San Diego State University,
152	University of Alabama-Birmingham,
153	Adelphi University,
154	Southern Illinois University-Carbondale,
155	St. John-s University New York,
156	University of Maryland-Baltimore County,
157	University of Massachusetts-Lowell,
158	University of South Florida,
159	Virginia Commonwealth University,
160	University of La Verne,
161	Biola University,
162	Florida Institute of Technology,
163	Immaculata University,
164	Maryville University of St. Louis,
165	Mississippi State University,
166	University of Hawaii-Manoa,
167	University of Rhode Island,
168	Ball State University,
169	Texas Tech University
170	University of Central Florida,
171	University of Idaho,
172	University of Louisville,
173	University of Maine,
174	University of Wyoming,
175	Andrews University,
176	Azusa Pacific University,
177	Edgewood College,
178	Kent State University,
179	West Virginia University,
180	Pace University,
181	St. Mary University of Minnesota,
182	University of New Mexico,
183	University of North Dakota,
184	University of South Dakota,
185	Bowling Green State University,
186	North Dakota State University,
187	South Dakota State University,
188	University of Alabama-Huntsville,
189	University of Houston,
190	University of Nevada-Reno,
191	University of North Carolina-Greensboro,
192	Western Michigan University,
193	Widener University,
194	Central Michigan University,
195	East Carolina University,
196	South Carolina State University,
197	University of Missouri-Kansas City,
198	University of North Carolina-Charlotte,
199	Ashland University,
200	Indiana University-Purdue University-Indianapolis,
201	Louisiana Tech University,
202	New Mexico State University,
203	University of Colorado-Denver,
204	Barry University,
205	Benedictine University,
206	Bowie State University,
207	Cardinal Stritch University,
208	Clark Atlanta University,
209	Cleveland State University,
210	East Tennessee State University,
211	Florida A&M University,
212	Florida Atlantic University,
213	Florida International University,
214	Georgia Southern University,
215	Georgia State University,
216	Indiana State University,
217	Indiana University of Pennsylvania,
218	Jackson State University,
219	Lamar University,
220	Lynn University,
221	Middle Tennessee State University,
222	Montana State University,
223	Morgan State University,
224	National Louis University,
225	North Carolina A&T State University,
226	Northern Arizona University,
227	Northern Illinois University,
228	Nova Southeastern University,
229	Oakland University,
230	Old Dominion University,
231	Our Lady of the Lake University,
232	Portland State University,
233	Regent University,
234	Sam Houston State University,
235	Spalding University,
236	Tennessee State University,
237	Texas A&M University-Commerce,
238	Texas A&M University-Corpus Christi,
239	Texas A&M University-Kingsville,
240	Texas Southern University,
241	Texas Woman-s University,
242	Trevecca Nazarene University,
243	Trinity International University,
244	University of Akron,
245	University of Alaska-Fairbanks,
246	University of Arkansas-Little Rock,
247	University of Louisiana-Lafayette,
248	University of Massachusetts-Boston,
249	University of Memphis,
250	University of Missouri-St. Louis,
251	University of Montana,
252	University of Nebraska-Omaha,
253	University of Nevada-Las Vegas,
254	University of New Orleans,
255	University of Northern Colorado,
256	University of North Texas,
257	University of South Alabama,
258	University of Southern Mississippi,
259	University of Texas-Arlington,
260	University of Texas-El Paso,
261	University of Texas-San Antonio,
262	University of Toledo,
263	University of West Florida,
264	University of Wisconsin-Milwaukee,
265	Utah State University,
266	Wayne State University,
267	Wichita State University,
268	Wright State University,
269	Alliant International University,
270	Argosy University,
271	California Institute of Integral Studies,
272	Capella University,
273	Colorado Technical University,
274	Idaho State University,
275	Northcentral University,
276	Trident University International,
277	Union Institute and University,
278	Walden University,
279	Wilmington University,
1000	Williams College,
1001	Amherst College,
1002	Swarthmore College,
1003	Bowdoin College
1004	Middlebury College
1005	Pomona College
1006	Wellesley College
1007	Carleton College
1008	Claremont McKenna College
1009	Davidson College
1010	United States Naval Academy
1011	Haverford College
1012	Vassar College
1013	Hamilton College
1014	Harvey Mudd College
1015	Smith College
1016	Washington and Lee University
1017	Wesleyan University
1018	Colby College
1019	Colgate University
1020	Grinnell College
1021	United States Military Academy
1022	Macalester College
1023	Oberlin College
1024	Bates College
1025	Bryn Mawr College
1026	Colorado College
1027	Kenyon College
1028	Barnard College
1029	Scripps College
1030	United States Air Force Academy
1031	Bucknell University
1032	College of the Holy Cross
1033	University of Richmond
1034	Mount Holyoke College
1035	Pitzer College
1036	Lafayette College
1037	Skidmore College
1038	Union College
1039	Dickinson College
1040	Franklin and Marshall College
1041	Whitman College
1042	Occidental College
1043	Trinity College
1044	Bard College
1045	Centre College
1046	Soka University of America
1047	Connecticut College
1048	Gettysburg College
1049	Sewanee-University of the South
1050	DePauw University
1051	Furman University
1052	Rhodes College
1053	St. Olaf College
1054	Denison University
1055	St. John s College
1056	Lawrence University
1057	Sarah Lawrence College
1058	Wheaton College
1059	St. Lawrence University
1060	Beloit College
1061	College of Wooster
1062	Earlham College
1063	Hobart and William Smith Colleges
1064	Wabash College
1065	Kalamazoo College
1066	Agnes Scott College
1067	Berea College
1068	Hillsdale College
1069	Wheaton College
1070	Willamette University
1071	Allegheny College
1072	Illinois Wesleyan University
1073	Knox College
1074	Lewis & Clark College
1075	Muhlenberg College
1076	Spelman College
1077	University of Puget Sound
1078	Austin College
1079	Gustavus Adolphus College
1080	St. John-s University
1081	College of the Atlantic
1082	Hendrix College
1083	New College of Florida
1084	St. Mary-s College
1085	Thomas Aquinas College
1086	Transylvania University
1087	Virginia Military Institute
1088	Wofford College
1089	College of St. Benedict
1090	Luther College
1091	Southwestern University
1092	Bennington College
1093	Cornell College
1094	Millsaps College
1095	Reed College
1096	St. Mary-s College of Maryland
1097	Ursinus College
1098	Westmont College
1099	Albion College
1100	Hope College
1101	St. John-s College
1102	Washington and Jefferson College
1103	Washington College
1104	Augustana College
1105	Juniata College
1106	St. Michael-s College
1107	Hampden-Sydney College
1108	Hollins University
1109	Lake Forest College
1110	Ohio Wesleyan University
1111	Drew University
1112	Goucher College
1113	Siena College
1114	St. Anselm College
1115	Coe College
1116	Hanover College
1117	Ripon College
1118	Stonehill College
1119	Birmingham-Southern College
1120	Calvin College
1121	Concordia College-Moorhead
1122	Linfield College
1123	Susquehanna University
1124	Randolph-Macon College
1125	Westminster College
1126	Berry College
1127	Eckerd College
1128	Goshen College
1129	Presbyterian College
1130	Principia College
1131	St. Norbert College
1132	Whittier College
1133	Grove City College
1134	McDaniel College
1135	Central College
1136	Houghton College
1137	Illinois College
1138	Marlboro College
1139	Salem College
1140	University of Minnesota-Morris
1141	Wells College
1142	Alma College
1143	Nebraska Wesleyan University
1144	Roanoke College
1145	Simpson College
1146	Wartburg College
1147	Centenary College of Louisiana
1148	Moravian College
1149	Morehouse College
1150	University of North Carolina-Asheville
1151	Westminster College Fulton
1152	Wittenberg University
1153	Carthage College
1154	Georgetown College
1155	Hiram College
1156	Saint Vincent College
1157	Doane College
1158	Gordon College
1159	Guilford College
1160	Randolph College
1161	Wesleyan College
1162	William Jewell College
1163	Hartwick College
1164	Lycoming College
1165	Warren Wilson College
1166	Monmouth College
1167	Oglethorpe University
1168	College of Idaho
1169	Ouachita Baptist University
1170	Eastern Mennonite University
1171	Fisk University
1172	Purchase College-SUNY
1173	Claflin University
1174	Emory and Henry College
1175	Wisconsin Lutheran College
1176	Albright College
1177	Allen University
1178	American Jewish University
1179	Amridge University
1180	Ave Maria University
1181	Bay Path University
1182	Bennett College
1183	Bethany College
1184	Bethany Lutheran College
1185	Bloomfield College
1186	Brevard College
1187	Bridgewater College
1188	Bryn Athyn College of the New Church
1189	Burlington College
1190	Castleton State College
1191	Colorado Mesa University
1192	Dillard University
1193	Eastern Nazarene College
1194	East-West University
1195	Erskine College
1196	Fort Lewis College
1197	Green Mountain College
1198	Harrisburg University of Science and Technology
1199	Holy Cross College
1200	Huston-Tillotson University
1201	Johnson C. Smith University
1202	Judson College
1203	Kentucky State University
1204	The King-s College
1205	Lane College
1206	Life University
1207	Louisiana State University-Alexandria
1208	Lyon College
1209	Marymount Manhattan College
1210	Maryville College
1211	Massachusetts College of Liberal Arts
1212	Northland College
1213	Pacific Union College
1214	Pine Manor College
1215	Rust College
1216	San Diego Christian College
1217	Savannah State University
1218	Shawnee State University
1219	Shorter University
1220	Simpson University
1221	Stillman College
1222	SUNY College-Old Westbury
1223	Tougaloo College
1224	University of Hawaii-Hilo
1225	University of Maine-Machias
1226	University of Pikeville
1227	University of Science and Arts of Oklahoma
1228	University of Virginia-Wise
1229	University of Wisconsin-Parkside
1230	Virginia Wesleyan College
1231	Western State Colorado University
1232	West Virginia State University
1233	William Peace University
1234	Xavier University of Louisiana
1235	Beacon College
1236	Charter Oak State College
1237	Granite State College
1238	Hampshire College
1239	Martin University
1240	National Hispanic University
1241	Shimer College
1242	Sterling College-Craftsbury Common
1243	Talladega College
1244	Thomas More College of Liberal Arts
2000	Villanova University
2001	Providence College
2002	Bentley University
2003	College of New Jersey
2004	Loyola University Maryland
2005	Fairfield University
2006	Rochester Institute of Technology
2007	University of Scranton
2008	Ithaca College
2009	Emerson College
2010	Bryant University
2011	Quinnipiac University
2012	Marist College
2013	SUNY-Geneseo
2014	St. Joseph-s University
2015	Simmons College
2016	Manhattan College
2017	Pratt Institute
2018	Gallaudet University
2019	Le Moyne College
2020	Rowan University
2021	Mount St. Mary-s University
2022	Rider University
2023	St. Bonaventure University
2024	SUNY-New Paltz
2025	La Salle University
2026	Ramapo College of New Jersey
2027	Wagner College
2028	Hood College
2029	Nazareth College
2030	Springfield College
2031	Assumption College
2032	CUNY-Baruch College
2033	Canisius College
2034	Montclair State University
2035	Molloy College
2036	Monmouth University
2037	Roger Williams University
2038	Rutgers, The State University of New Jersey-Camden
2039	Salve Regina University
2040	Arcadia University
2041	Marywood University
2042	Mercyhurst University
2043	New York Institute of Technology
2044	Sacred Heart University
2045	St. Francis University
2046	Alfred University
2047	CUNY-Hunter College
2048	CUNY-Queens College
2049	Misericordia University
2050	Niagara University
2051	SUNY College-Oneonta
2052	Chatham University
2053	College of St. Rose
2054	King-s College
2055	Stockton University
2056	Towson University
2057	College at Brockport-SUNY
2058	Gannon University
2059	Johnson & Wales University
2060	Notre Dame of Maryland University
2061	Suffolk University
2062	Philadelphia University
2063	SUNY-Oswego
2064	Western New England University
2065	CUNY-City College
2066	Emmanuel College
2067	Endicott College
2068	Robert Morris University
2069	SUNY-Fredonia
2070	DeSales University
2071	Salisbury University
2072	West Chester University of Pennsylvania
2073	St. Joseph-s College New York
2074	SUNY College-Cortland
2075	Keene State College
2076	Norwich University
2077	SUNY-Plattsburgh
2078	Iona College
2079	Slippery Rock University of Pennsylvania
2080	Stevenson University
2081	University of St. Joseph
2082	CUNY-Brooklyn College
2083	Eastern University
2084	Fairleigh Dickinson University
2085	Millersville University of Pennsylvania
2086	Roberts Wesleyan College
2087	University of Massachusetts-Dartmouth
2088	University of New England
2089	Wilkes University
2090	York College of Pennsylvania
2091	Eastern Connecticut State University
2092	Manhattanville College
2093	Shippensburg University of Pennsylvania
2094	St. Peter-s University
2095	SUNY College-Potsdam
2096	University of Hartford
2097	University of New Haven
2098	Wheelock College
2099	Plymouth State University
2100	The Sage Colleges
2101	Waynesburg University
2102	Caldwell University
2103	Bloomsburg University of Pennsylvania
2104	William Paterson University of New Jersey
2105	Cairn University
2106	Central Connecticut State University
2107	Mount St. Mary College
2108	Albertus Magnus College
2109	Alvernia University
2110	St. Thomas Aquinas College
2111	College of Mount St. Vincent
2112	College of St. Elizabeth
2113	Lesley University
2114	Point Park University
2115	College of New Rochelle
2116	CUNY-Lehman College
2117	Rosemont College
2118	Utica College
2119	Westfield State University
2120	Worcester State University
2121	SUNY Buffalo State
2122	SUNY Polytechnic Institute
2123	University of Baltimore
2124	Bridgewater State University
2125	CUNY-John Jay College of Criminal Justice
2126	Delaware State University
2127	Frostburg State University
2128	Holy Family University
2129	Southern Connecticut State University
2130	Chestnut Hill College
2131	East Stroudsburg University of Pennsylvania
2132	Georgian Court University
2133	Gwynedd Mercy University
2134	Kutztown University of Pennsylvania
2135	Mansfield University of Pennsylvania
2136	Rhode Island College
2137	Southern New Hampshire University
2138	American International College
2139	Anna Maria College
2140	Cabrini College
2141	California University of Pennsylvania
2142	Carlow University
2143	Centenary College
2144	Cheyney University of Pennsylvania
2145	Clarion University of Pennsylvania
2146	College of St. Joseph
2147	Coppin State University
2148	CUNY-College of Staten Island
2149	Curry College
2150	Daemen College
2151	Dominican College
2152	Dowling College
2153	D-Youville College
2154	Edinboro University of Pennsylvania
2155	Felician College
2156	Fitchburg State University
2157	Framingham State University
2158	Franklin Pierce University
2159	Husson University
2160	Johnson State College
2161	Kean University
2162	Keuka College
2163	Lincoln University
2164	LIU Post
2165	Lock Haven University of Pennsylvania
2166	Medaille College
2167	Metropolitan College of New York
2168	Monroe College
2169	Neumann University
2170	New England College
2171	New Jersey City University
2172	Nyack College
2173	Rivier University
2174	Salem State University
2175	St. Joseph-s College
2176	Touro College
2177	Trinity Washington University
2178	University of Bridgeport
2179	University of Maryland-Eastern Shore
2180	University of Southern Maine
2181	University of the District of Columbia
2182	Western Connecticut State University
2183	Cambridge College
2184	Excelsior College
2185	Fashion Institute of Technology
2186	Goddard College
2187	Gratz College
2188	Mercy College
2189	Strayer University
2190	SUNY Empire State College
2191	Thomas Edison State College
2192	University of Maryland University College
3000	Trinity University
3001	Santa Clara University
3002	Loyola Marymount University
3003	Gonzaga University
3004	Mills College
3005	Seattle University
3006	Chapman University
3007	University of Portland
3008	St. Mary-s College of California
3009	California Polytechnic State University-San Luis Obispo
3010	Whitworth University
3011	University of Redlands
3012	St. Edward-s University
3013	Pacific Lutheran University
3014	University of Dallas
3015	California Lutheran University
3016	Abilene Christian University
3017	Point Loma Nazarene University
3018	Seattle Pacific University
3019	Westminster College
3020	Western Washington University
3021	St. Mary-s University of San Antonio
3022	Mount Saint Mary s University
3023	Oklahoma City University
3024	Dominican University of California
3025	New Mexico Institute of Mining and Technology
3026	Pacific University
3027	George Fox University
3028	Regis University
3029	University of St. Thomas
3030	California State Polytechnic University-Pomona
3031	California State University-Long Beach
3032	LeTourneau University
3033	Hardin-Simmons University
3034	Dallas Baptist University
3035	Evergreen State College
3036	California State University-Fullerton
3037	Fresno Pacific University
3038	California Baptist University
3039	Notre Dame de Namur University
3040	San Jose State University
3041	Alaska Pacific University
3042	California State University-Chico
3043	Oklahoma Christian University
3044	Walla Walla University
3045	St. Martin-s University
3046	University of Colorado-Colorado Springs
3047	Sonoma State University
3048	Texas Wesleyan University
3049	Holy Names University
3050	Oral Roberts University
3051	California State University-Fresno
3052	Central Washington University
3053	Texas State University
3054	Concordia University Irvine
3055	University of Mary Hardin-Baylor
3056	California State University-Stanislaus
3057	Humboldt State University
3058	La Sierra University
3059	Woodbury University
3060	Boise State University
3061	Northwest Nazarene University
3062	California State University-Los Angeles
3063	California State University-Monterey Bay
3064	California State University-Sacramento
3065	Eastern Washington University
3066	San Francisco State University
3067	University of the Incarnate Word
3068	California State University-San Bernardino
3069	California State University-Nridge
3070	Southern Utah University
3071	Texas A&M International University
3072	Chaminade University of Honolulu
3073	Houston Baptist University
3074	Southern Oregon University
3075	University of Texas-Tyler
3076	Hawaii Pacific University
3077	University of Alaska-Anchorage
3078	Weber State University
3079	Western Oregon University
3080	University of Central Oklahoma
3081	University of Houston-Clear Lake
3082	California State University-Bakersfield
3083	Lubbock Christian University
3084	Prescott College
3085	Southern Nazarene University
3086	California State University-Channel Islands
3087	California State University-San Marcos
3088	Stephen F. Austin State University
3090	Adams State University
3091	Angelo State University
3092	California State University-Dominguez Hills
3093	California State University-East Bay
3094	Cameron University
3095	Colorado Christian University
3096	Colorado State University-Pueblo
3097	Concordia University Portland
3098	Concordia University Texas
3099	East Central University
3100	Eastern New Mexico University
3101	Eastern Oregon University
3102	Grand Canyon University
3103	Midwestern State University
3104	Montana State University-Billings
3105	Northeastern State University
3106	Northwestern Oklahoma State University
3107	Prairie View A&M University
3108	Sierra Nevada College
3109	Southeastern Oklahoma State University
3120	Southwestern Assemblies of God University
3121	Southwestern Oklahoma State University
3122	Sul Ross State University
3123	Tarleton State University
3124	Texas A&M University-Texarkana
3125	University of Houston-Victoria
3126	University of Texas of the Permian Basin
3127	Wayland Baptist University
3128	West Texas A&M University
3129	Amberton University
3130	Ashford University
3131	Brandman University
3132	City University of Seattle
3133	Golden Gate University
3134	Heritage University
3135	John F. Kennedy University
3136	Jones International University
3137	Langston University
3138	Marylhurst University
3139	Naropa University
3140	National University
3141	New Mexico Highlands University
3142	University of Alaska-Southeast
3143	Western Governors University
3144	Western International University
3145	Western New Mexico University
3146	California State University-Merced
4000	Creighton University
4001	Butler University
4002	Drake University
4003	Bradley University
4004	Valparaiso University
4005	Xavier University
4006	John Carroll University
4007	Truman State University
4008	University of Evansville
4009	Elmhurst College
4011	Drury University
4012	Hamline University
4013	Baldwin Wallace University
4014	Otterbein University
4015	Milwaukee School of Engineering
4016	North Central College
4017	St. Catherine University
4018	Rockhurst University
4019	University of Northern Iowa
4020	Augsburg College
4021	Dominican University
4022	Franciscan University of Steubenville
4023	Bethel University
4024	Kettering University
4025	University of Detroit Mercy
4026	Grand Valley State University
4027	Webster University
4028	Lewis University
4029	University of Wisconsin-La Crosse
4030	Eastern Illinois University
4031	Indiana Wesleyan University
4032	University of Indianapolis
4033	College of St. Scholastica
4034	University of Wisconsin-Eau Claire
4035	Anderson University
4036	Baker University
4037	Capital University
4038	St. Ambrose University
4039	University of Michigan-Dearborn
4040	University of Minnesota-Duluth
4041	University of St. Francis
4042	Carroll University
4043	University of Illinois-Springfield
4044	Concordia University Seward
4045	Southern Illinois University-Edwardsville
4046	St. Xavier University
4047	University of Nebraska-Kearney
4048	Western Illinois University
4049	Heidelberg University
4050	Muskingum University
4051	University of Wisconsin-Stevens Point
4052	University of Wisconsin-Whitewater
4053	Ursuline College
4054	Aquinas College
4055	Concordia University Wisconsin
4056	Lawrence Technological University
4057	North Park University
4058	Olivet Nazarene University
4059	University of Findlay
4060	Walsh University
4061	Ferris State University
4062	Malone University
4063	Mount Vernon Nazarene University
4064	Alverno College
4065	Missouri State University
4066	Spring Arbor University
4067	University of Wisconsin-Stout
4068	McKendree University
4069	Mount St. Joseph University
4070	Quincy University
4071	Tiffin University
4072	University of Wisconsin-River Falls
4073	Winona State University
4074	Northwest Missouri State University
4075	College of St. Mary
4076	Concordia University Chicago
4077	Minnesota State University-Mankato
4078	Mount Mary University
4079	University of Central Missouri
4080	University of Wisconsin-Green Bay
4081	University of Wisconsin-Oshkosh
4082	Wayne State College
4083	Marian University
4084	University of Wisconsin-Platteville
4085	Eastern Michigan University
4086	Fontbonne University
4087	Northern Michigan University
4088	Ohio Dominican University
4089	Pittsburg State University
4090	Rockford University
4091	William Woods University
4092	Dakota State University
4093	Siena Heights University
4094	Southeast Missouri State University
4095	University of Saint Francis
4096	University of Wisconsin-Superior
4097	Washburn University
4098	Madonna University
4099	Bemidji State University
4100	Concordia University-St. Paul
4101	Southwestern College
4102	St. Cloud State University
4103	University of Michigan-Flint
4104	Emporia State University
4105	Graceland University
4106	Robert Morris University
4107	Viterbo University
4108	Cornerstone University
4109	Lindenwood University
4110	Minnesota State University-Moorhead
4111	University of Dubuque
4112	Minot State University
4113	Roosevelt University
4114	Aurora University
4115	Avila University
4116	Black Hills State University
4117	Calumet College of St. Joseph
4118	Chicago State University
4119	Columbia College Chicago
4120	Davenport University
4121	DeVry University
4122	Fort Hays State University
4123	Friends University
4124	Governors State University
4125	Indiana University Northwest
4126	Indiana University-Purdue University-Fort Wayne
4127	Indiana University-South Bend
4128	Indiana University Southeast
4129	Lake Erie College
4130	Lakeland College
4131	Lincoln University Jefferson City
4132	Lourdes University
4133	Marygrove College
4134	Metropolitan State University
4135	MidAmerica Nazarene University
4136	Missouri Baptist University
4137	Newman University
4138	Northeastern Illinois University
4139	Oakland City University
4140	Park University
4141	Purdue University-Calumet
4142	Saginaw Valley State University
4143	Southwest Baptist University
4144	Southwest Minnesota State University
4145	University of Mary
4146	University of Southern Indiana
4147	University of St. Mary
);
