PGDMP  0    /                |            P BETPLAY BACKEND    16.3    16.3 S    ~           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    32768    P BETPLAY BACKEND    DATABASE     u   CREATE DATABASE "P BETPLAY BACKEND" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'C';
 #   DROP DATABASE "P BETPLAY BACKEND";
                postgres    false            �            1259    32912    arbitros    TABLE     �   CREATE TABLE public.arbitros (
    id_arbitro integer NOT NULL,
    nombre character varying(50) NOT NULL,
    apellido character varying(50) NOT NULL,
    nacionalidad character varying(50),
    fecha_nacimiento date
);
    DROP TABLE public.arbitros;
       public         heap    postgres    false            �            1259    32911    arbitros_id_arbitro_seq    SEQUENCE     �   CREATE SEQUENCE public.arbitros_id_arbitro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.arbitros_id_arbitro_seq;
       public          postgres    false    230            �           0    0    arbitros_id_arbitro_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.arbitros_id_arbitro_seq OWNED BY public.arbitros.id_arbitro;
          public          postgres    false    229            �            1259    32784    asignacion_jugador_equipo    TABLE     �   CREATE TABLE public.asignacion_jugador_equipo (
    id_asignacion integer NOT NULL,
    id_jugador integer NOT NULL,
    id_equipo integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date
);
 -   DROP TABLE public.asignacion_jugador_equipo;
       public         heap    postgres    false            �            1259    32783 +   asignacion_jugador_equipo_id_asignacion_seq    SEQUENCE     �   CREATE SEQUENCE public.asignacion_jugador_equipo_id_asignacion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 B   DROP SEQUENCE public.asignacion_jugador_equipo_id_asignacion_seq;
       public          postgres    false    220            �           0    0 +   asignacion_jugador_equipo_id_asignacion_seq    SEQUENCE OWNED BY     {   ALTER SEQUENCE public.asignacion_jugador_equipo_id_asignacion_seq OWNED BY public.asignacion_jugador_equipo.id_asignacion;
          public          postgres    false    219            �            1259    32770    equipo    TABLE     �   CREATE TABLE public.equipo (
    id_equipo integer NOT NULL,
    nombre character varying(50) NOT NULL,
    ciudad character varying(50),
    estadio character varying(50),
    entrenador character varying(50)
);
    DROP TABLE public.equipo;
       public         heap    postgres    false            �            1259    32769    equipo_id_equipo_seq    SEQUENCE     �   CREATE SEQUENCE public.equipo_id_equipo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.equipo_id_equipo_seq;
       public          postgres    false    216            �           0    0    equipo_id_equipo_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.equipo_id_equipo_seq OWNED BY public.equipo.id_equipo;
          public          postgres    false    215            �            1259    32864    estadisticas_del_partido    TABLE     �  CREATE TABLE public.estadisticas_del_partido (
    id_estadistica integer NOT NULL,
    id_partido integer,
    id_equipo integer,
    posesion double precision,
    tiros_a_puerta integer DEFAULT 0,
    tiros_fuera integer DEFAULT 0,
    faltas integer DEFAULT 0,
    corners integer DEFAULT 0,
    tarjetas_amarillas integer DEFAULT 0,
    tarjetas_rojas integer DEFAULT 0,
    tiroesquina_resultado integer NOT NULL,
    rematearco_resultado integer NOT NULL
);
 ,   DROP TABLE public.estadisticas_del_partido;
       public         heap    postgres    false            �            1259    32863 +   estadisticas_del_partido_id_estadistica_seq    SEQUENCE     �   CREATE SEQUENCE public.estadisticas_del_partido_id_estadistica_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 B   DROP SEQUENCE public.estadisticas_del_partido_id_estadistica_seq;
       public          postgres    false    226            �           0    0 +   estadisticas_del_partido_id_estadistica_seq    SEQUENCE OWNED BY     {   ALTER SEQUENCE public.estadisticas_del_partido_id_estadistica_seq OWNED BY public.estadisticas_del_partido.id_estadistica;
          public          postgres    false    225            �            1259    32934    eventos_del_partido    TABLE     �   CREATE TABLE public.eventos_del_partido (
    id_evento integer NOT NULL,
    id_partido integer,
    id_jugador integer,
    tipo_evento character varying(50) NOT NULL,
    minuto integer NOT NULL
);
 '   DROP TABLE public.eventos_del_partido;
       public         heap    postgres    false            �            1259    32933 !   eventos_del_partido_id_evento_seq    SEQUENCE     �   CREATE SEQUENCE public.eventos_del_partido_id_evento_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.eventos_del_partido_id_evento_seq;
       public          postgres    false    233            �           0    0 !   eventos_del_partido_id_evento_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.eventos_del_partido_id_evento_seq OWNED BY public.eventos_del_partido.id_evento;
          public          postgres    false    232            �            1259    32801    jornadas    TABLE     �   CREATE TABLE public.jornadas (
    id_jornada integer NOT NULL,
    numero integer NOT NULL,
    fecha_inicio date NOT NULL,
    fecha_fin date NOT NULL
);
    DROP TABLE public.jornadas;
       public         heap    postgres    false            �            1259    32800    jornadas_id_jornada_seq    SEQUENCE     �   CREATE SEQUENCE public.jornadas_id_jornada_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.jornadas_id_jornada_seq;
       public          postgres    false    222            �           0    0    jornadas_id_jornada_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.jornadas_id_jornada_seq OWNED BY public.jornadas.id_jornada;
          public          postgres    false    221            �            1259    32777    jugador    TABLE     &  CREATE TABLE public.jugador (
    id_jugador integer NOT NULL,
    nombre character varying(50) NOT NULL,
    posicion character varying(50),
    numero_camisa integer,
    nacionalidad character varying(50),
    piernahabil_jugador character varying(50) NOT NULL,
    fecha_nacimiento date
);
    DROP TABLE public.jugador;
       public         heap    postgres    false            �            1259    32776    jugador_id_jugador_seq    SEQUENCE     �   CREATE SEQUENCE public.jugador_id_jugador_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.jugador_id_jugador_seq;
       public          postgres    false    218            �           0    0    jugador_id_jugador_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.jugador_id_jugador_seq OWNED BY public.jugador.id_jugador;
          public          postgres    false    217            �            1259    32808    partido    TABLE     H  CREATE TABLE public.partido (
    id_partido integer NOT NULL,
    fecha timestamp without time zone NOT NULL,
    estadio character varying(100),
    equipo_local integer NOT NULL,
    equipo_visitante integer NOT NULL,
    goles_local integer DEFAULT 0,
    goles_visitante integer DEFAULT 0,
    jornada integer DEFAULT 0
);
    DROP TABLE public.partido;
       public         heap    postgres    false            �            1259    32807    partido_id_partido_seq    SEQUENCE     �   CREATE SEQUENCE public.partido_id_partido_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.partido_id_partido_seq;
       public          postgres    false    224            �           0    0    partido_id_partido_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.partido_id_partido_seq OWNED BY public.partido.id_partido;
          public          postgres    false    223            �            1259    32918    partidos_y_arbitros    TABLE     �   CREATE TABLE public.partidos_y_arbitros (
    id_partido integer NOT NULL,
    id_arbitro integer NOT NULL,
    tipo_arbitro character varying(50) NOT NULL
);
 '   DROP TABLE public.partidos_y_arbitros;
       public         heap    postgres    false            �            1259    32887    tabla_de_posiciones    TABLE     �  CREATE TABLE public.tabla_de_posiciones (
    id_posicion integer NOT NULL,
    id_equipo integer,
    id_jornada integer,
    puntos integer DEFAULT 0,
    partidos_jugados integer DEFAULT 0,
    ganados integer DEFAULT 0,
    empatados integer DEFAULT 0,
    perdidos integer DEFAULT 0,
    goles_favor integer DEFAULT 0,
    goles_contra integer DEFAULT 0,
    diferencia_goles integer DEFAULT 0
);
 '   DROP TABLE public.tabla_de_posiciones;
       public         heap    postgres    false            �            1259    32886 #   tabla_de_posiciones_id_posicion_seq    SEQUENCE     �   CREATE SEQUENCE public.tabla_de_posiciones_id_posicion_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.tabla_de_posiciones_id_posicion_seq;
       public          postgres    false    228            �           0    0 #   tabla_de_posiciones_id_posicion_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.tabla_de_posiciones_id_posicion_seq OWNED BY public.tabla_de_posiciones.id_posicion;
          public          postgres    false    227            �           2604    32915    arbitros id_arbitro    DEFAULT     z   ALTER TABLE ONLY public.arbitros ALTER COLUMN id_arbitro SET DEFAULT nextval('public.arbitros_id_arbitro_seq'::regclass);
 B   ALTER TABLE public.arbitros ALTER COLUMN id_arbitro DROP DEFAULT;
       public          postgres    false    230    229    230            �           2604    32787 '   asignacion_jugador_equipo id_asignacion    DEFAULT     �   ALTER TABLE ONLY public.asignacion_jugador_equipo ALTER COLUMN id_asignacion SET DEFAULT nextval('public.asignacion_jugador_equipo_id_asignacion_seq'::regclass);
 V   ALTER TABLE public.asignacion_jugador_equipo ALTER COLUMN id_asignacion DROP DEFAULT;
       public          postgres    false    219    220    220            �           2604    32773    equipo id_equipo    DEFAULT     t   ALTER TABLE ONLY public.equipo ALTER COLUMN id_equipo SET DEFAULT nextval('public.equipo_id_equipo_seq'::regclass);
 ?   ALTER TABLE public.equipo ALTER COLUMN id_equipo DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    32867 '   estadisticas_del_partido id_estadistica    DEFAULT     �   ALTER TABLE ONLY public.estadisticas_del_partido ALTER COLUMN id_estadistica SET DEFAULT nextval('public.estadisticas_del_partido_id_estadistica_seq'::regclass);
 V   ALTER TABLE public.estadisticas_del_partido ALTER COLUMN id_estadistica DROP DEFAULT;
       public          postgres    false    226    225    226            �           2604    32937    eventos_del_partido id_evento    DEFAULT     �   ALTER TABLE ONLY public.eventos_del_partido ALTER COLUMN id_evento SET DEFAULT nextval('public.eventos_del_partido_id_evento_seq'::regclass);
 L   ALTER TABLE public.eventos_del_partido ALTER COLUMN id_evento DROP DEFAULT;
       public          postgres    false    232    233    233            �           2604    32804    jornadas id_jornada    DEFAULT     z   ALTER TABLE ONLY public.jornadas ALTER COLUMN id_jornada SET DEFAULT nextval('public.jornadas_id_jornada_seq'::regclass);
 B   ALTER TABLE public.jornadas ALTER COLUMN id_jornada DROP DEFAULT;
       public          postgres    false    221    222    222            �           2604    32780    jugador id_jugador    DEFAULT     x   ALTER TABLE ONLY public.jugador ALTER COLUMN id_jugador SET DEFAULT nextval('public.jugador_id_jugador_seq'::regclass);
 A   ALTER TABLE public.jugador ALTER COLUMN id_jugador DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    32811    partido id_partido    DEFAULT     x   ALTER TABLE ONLY public.partido ALTER COLUMN id_partido SET DEFAULT nextval('public.partido_id_partido_seq'::regclass);
 A   ALTER TABLE public.partido ALTER COLUMN id_partido DROP DEFAULT;
       public          postgres    false    223    224    224            �           2604    32890    tabla_de_posiciones id_posicion    DEFAULT     �   ALTER TABLE ONLY public.tabla_de_posiciones ALTER COLUMN id_posicion SET DEFAULT nextval('public.tabla_de_posiciones_id_posicion_seq'::regclass);
 N   ALTER TABLE public.tabla_de_posiciones ALTER COLUMN id_posicion DROP DEFAULT;
       public          postgres    false    228    227    228            x          0    32912    arbitros 
   TABLE DATA           `   COPY public.arbitros (id_arbitro, nombre, apellido, nacionalidad, fecha_nacimiento) FROM stdin;
    public          postgres    false    230   �p       n          0    32784    asignacion_jugador_equipo 
   TABLE DATA           r   COPY public.asignacion_jugador_equipo (id_asignacion, id_jugador, id_equipo, fecha_inicio, fecha_fin) FROM stdin;
    public          postgres    false    220   �p       j          0    32770    equipo 
   TABLE DATA           P   COPY public.equipo (id_equipo, nombre, ciudad, estadio, entrenador) FROM stdin;
    public          postgres    false    216   q       t          0    32864    estadisticas_del_partido 
   TABLE DATA           �   COPY public.estadisticas_del_partido (id_estadistica, id_partido, id_equipo, posesion, tiros_a_puerta, tiros_fuera, faltas, corners, tarjetas_amarillas, tarjetas_rojas, tiroesquina_resultado, rematearco_resultado) FROM stdin;
    public          postgres    false    226   q       {          0    32934    eventos_del_partido 
   TABLE DATA           e   COPY public.eventos_del_partido (id_evento, id_partido, id_jugador, tipo_evento, minuto) FROM stdin;
    public          postgres    false    233   <q       p          0    32801    jornadas 
   TABLE DATA           O   COPY public.jornadas (id_jornada, numero, fecha_inicio, fecha_fin) FROM stdin;
    public          postgres    false    222   Yq       l          0    32777    jugador 
   TABLE DATA           �   COPY public.jugador (id_jugador, nombre, posicion, numero_camisa, nacionalidad, piernahabil_jugador, fecha_nacimiento) FROM stdin;
    public          postgres    false    218   vq       r          0    32808    partido 
   TABLE DATA           �   COPY public.partido (id_partido, fecha, estadio, equipo_local, equipo_visitante, goles_local, goles_visitante, jornada) FROM stdin;
    public          postgres    false    224   �q       y          0    32918    partidos_y_arbitros 
   TABLE DATA           S   COPY public.partidos_y_arbitros (id_partido, id_arbitro, tipo_arbitro) FROM stdin;
    public          postgres    false    231   �q       v          0    32887    tabla_de_posiciones 
   TABLE DATA           �   COPY public.tabla_de_posiciones (id_posicion, id_equipo, id_jornada, puntos, partidos_jugados, ganados, empatados, perdidos, goles_favor, goles_contra, diferencia_goles) FROM stdin;
    public          postgres    false    228   �q       �           0    0    arbitros_id_arbitro_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.arbitros_id_arbitro_seq', 1, false);
          public          postgres    false    229            �           0    0 +   asignacion_jugador_equipo_id_asignacion_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('public.asignacion_jugador_equipo_id_asignacion_seq', 1, false);
          public          postgres    false    219            �           0    0    equipo_id_equipo_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.equipo_id_equipo_seq', 1, false);
          public          postgres    false    215            �           0    0 +   estadisticas_del_partido_id_estadistica_seq    SEQUENCE SET     Z   SELECT pg_catalog.setval('public.estadisticas_del_partido_id_estadistica_seq', 1, false);
          public          postgres    false    225            �           0    0 !   eventos_del_partido_id_evento_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('public.eventos_del_partido_id_evento_seq', 1, false);
          public          postgres    false    232            �           0    0    jornadas_id_jornada_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.jornadas_id_jornada_seq', 1, false);
          public          postgres    false    221            �           0    0    jugador_id_jugador_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.jugador_id_jugador_seq', 1, false);
          public          postgres    false    217            �           0    0    partido_id_partido_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.partido_id_partido_seq', 1, false);
          public          postgres    false    223            �           0    0 #   tabla_de_posiciones_id_posicion_seq    SEQUENCE SET     R   SELECT pg_catalog.setval('public.tabla_de_posiciones_id_posicion_seq', 1, false);
          public          postgres    false    227            �           2606    32917    arbitros arbitros_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.arbitros
    ADD CONSTRAINT arbitros_pkey PRIMARY KEY (id_arbitro);
 @   ALTER TABLE ONLY public.arbitros DROP CONSTRAINT arbitros_pkey;
       public            postgres    false    230            �           2606    32789 8   asignacion_jugador_equipo asignacion_jugador_equipo_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.asignacion_jugador_equipo
    ADD CONSTRAINT asignacion_jugador_equipo_pkey PRIMARY KEY (id_asignacion);
 b   ALTER TABLE ONLY public.asignacion_jugador_equipo DROP CONSTRAINT asignacion_jugador_equipo_pkey;
       public            postgres    false    220            �           2606    32775    equipo equipo_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.equipo
    ADD CONSTRAINT equipo_pkey PRIMARY KEY (id_equipo);
 <   ALTER TABLE ONLY public.equipo DROP CONSTRAINT equipo_pkey;
       public            postgres    false    216            �           2606    32875 6   estadisticas_del_partido estadisticas_del_partido_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.estadisticas_del_partido
    ADD CONSTRAINT estadisticas_del_partido_pkey PRIMARY KEY (id_estadistica);
 `   ALTER TABLE ONLY public.estadisticas_del_partido DROP CONSTRAINT estadisticas_del_partido_pkey;
       public            postgres    false    226            �           2606    32939 ,   eventos_del_partido eventos_del_partido_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.eventos_del_partido
    ADD CONSTRAINT eventos_del_partido_pkey PRIMARY KEY (id_evento);
 V   ALTER TABLE ONLY public.eventos_del_partido DROP CONSTRAINT eventos_del_partido_pkey;
       public            postgres    false    233            �           2606    32806    jornadas jornadas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.jornadas
    ADD CONSTRAINT jornadas_pkey PRIMARY KEY (id_jornada);
 @   ALTER TABLE ONLY public.jornadas DROP CONSTRAINT jornadas_pkey;
       public            postgres    false    222            �           2606    32782    jugador jugador_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.jugador
    ADD CONSTRAINT jugador_pkey PRIMARY KEY (id_jugador);
 >   ALTER TABLE ONLY public.jugador DROP CONSTRAINT jugador_pkey;
       public            postgres    false    218            �           2606    32816    partido partido_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_pkey PRIMARY KEY (id_partido);
 >   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_pkey;
       public            postgres    false    224            �           2606    32922 ,   partidos_y_arbitros partidos_y_arbitros_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.partidos_y_arbitros
    ADD CONSTRAINT partidos_y_arbitros_pkey PRIMARY KEY (id_partido, id_arbitro);
 V   ALTER TABLE ONLY public.partidos_y_arbitros DROP CONSTRAINT partidos_y_arbitros_pkey;
       public            postgres    false    231    231            �           2606    32900 ,   tabla_de_posiciones tabla_de_posiciones_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY public.tabla_de_posiciones
    ADD CONSTRAINT tabla_de_posiciones_pkey PRIMARY KEY (id_posicion);
 V   ALTER TABLE ONLY public.tabla_de_posiciones DROP CONSTRAINT tabla_de_posiciones_pkey;
       public            postgres    false    228            �           2606    32795 B   asignacion_jugador_equipo asignacion_jugador_equipo_id_equipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignacion_jugador_equipo
    ADD CONSTRAINT asignacion_jugador_equipo_id_equipo_fkey FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) ON DELETE CASCADE;
 l   ALTER TABLE ONLY public.asignacion_jugador_equipo DROP CONSTRAINT asignacion_jugador_equipo_id_equipo_fkey;
       public          postgres    false    220    3514    216            �           2606    32790 C   asignacion_jugador_equipo asignacion_jugador_equipo_id_jugador_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.asignacion_jugador_equipo
    ADD CONSTRAINT asignacion_jugador_equipo_id_jugador_fkey FOREIGN KEY (id_jugador) REFERENCES public.jugador(id_jugador) ON DELETE CASCADE;
 m   ALTER TABLE ONLY public.asignacion_jugador_equipo DROP CONSTRAINT asignacion_jugador_equipo_id_jugador_fkey;
       public          postgres    false    3516    220    218            �           2606    32881 @   estadisticas_del_partido estadisticas_del_partido_id_equipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estadisticas_del_partido
    ADD CONSTRAINT estadisticas_del_partido_id_equipo_fkey FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) ON DELETE CASCADE;
 j   ALTER TABLE ONLY public.estadisticas_del_partido DROP CONSTRAINT estadisticas_del_partido_id_equipo_fkey;
       public          postgres    false    226    216    3514            �           2606    32876 A   estadisticas_del_partido estadisticas_del_partido_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.estadisticas_del_partido
    ADD CONSTRAINT estadisticas_del_partido_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;
 k   ALTER TABLE ONLY public.estadisticas_del_partido DROP CONSTRAINT estadisticas_del_partido_id_partido_fkey;
       public          postgres    false    226    224    3522            �           2606    32945 7   eventos_del_partido eventos_del_partido_id_jugador_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.eventos_del_partido
    ADD CONSTRAINT eventos_del_partido_id_jugador_fkey FOREIGN KEY (id_jugador) REFERENCES public.jugador(id_jugador) ON DELETE SET NULL;
 a   ALTER TABLE ONLY public.eventos_del_partido DROP CONSTRAINT eventos_del_partido_id_jugador_fkey;
       public          postgres    false    3516    233    218            �           2606    32940 7   eventos_del_partido eventos_del_partido_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.eventos_del_partido
    ADD CONSTRAINT eventos_del_partido_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;
 a   ALTER TABLE ONLY public.eventos_del_partido DROP CONSTRAINT eventos_del_partido_id_partido_fkey;
       public          postgres    false    224    233    3522            �           2606    32822 !   partido partido_equipo_local_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_equipo_local_fkey FOREIGN KEY (equipo_local) REFERENCES public.equipo(id_equipo) ON DELETE CASCADE;
 K   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_equipo_local_fkey;
       public          postgres    false    3514    224    216            �           2606    32827 %   partido partido_equipo_visitante_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_equipo_visitante_fkey FOREIGN KEY (equipo_visitante) REFERENCES public.equipo(id_equipo) ON DELETE CASCADE;
 O   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_equipo_visitante_fkey;
       public          postgres    false    216    224    3514            �           2606    32817    partido partido_jornada_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partido
    ADD CONSTRAINT partido_jornada_fkey FOREIGN KEY (jornada) REFERENCES public.jornadas(id_jornada) ON DELETE CASCADE;
 F   ALTER TABLE ONLY public.partido DROP CONSTRAINT partido_jornada_fkey;
       public          postgres    false    222    3520    224            �           2606    32928 7   partidos_y_arbitros partidos_y_arbitros_id_arbitro_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partidos_y_arbitros
    ADD CONSTRAINT partidos_y_arbitros_id_arbitro_fkey FOREIGN KEY (id_arbitro) REFERENCES public.arbitros(id_arbitro) ON DELETE CASCADE;
 a   ALTER TABLE ONLY public.partidos_y_arbitros DROP CONSTRAINT partidos_y_arbitros_id_arbitro_fkey;
       public          postgres    false    230    231    3528            �           2606    32923 7   partidos_y_arbitros partidos_y_arbitros_id_partido_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.partidos_y_arbitros
    ADD CONSTRAINT partidos_y_arbitros_id_partido_fkey FOREIGN KEY (id_partido) REFERENCES public.partido(id_partido) ON DELETE CASCADE;
 a   ALTER TABLE ONLY public.partidos_y_arbitros DROP CONSTRAINT partidos_y_arbitros_id_partido_fkey;
       public          postgres    false    224    3522    231            �           2606    32901 6   tabla_de_posiciones tabla_de_posiciones_id_equipo_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tabla_de_posiciones
    ADD CONSTRAINT tabla_de_posiciones_id_equipo_fkey FOREIGN KEY (id_equipo) REFERENCES public.equipo(id_equipo) ON DELETE CASCADE;
 `   ALTER TABLE ONLY public.tabla_de_posiciones DROP CONSTRAINT tabla_de_posiciones_id_equipo_fkey;
       public          postgres    false    228    216    3514            �           2606    32906 7   tabla_de_posiciones tabla_de_posiciones_id_jornada_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.tabla_de_posiciones
    ADD CONSTRAINT tabla_de_posiciones_id_jornada_fkey FOREIGN KEY (id_jornada) REFERENCES public.jornadas(id_jornada) ON DELETE CASCADE;
 a   ALTER TABLE ONLY public.tabla_de_posiciones DROP CONSTRAINT tabla_de_posiciones_id_jornada_fkey;
       public          postgres    false    3520    228    222            x      x������ � �      n      x������ � �      j      x������ � �      t      x������ � �      {      x������ � �      p      x������ � �      l      x������ � �      r      x������ � �      y      x������ � �      v      x������ � �     