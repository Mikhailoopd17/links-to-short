PGDMP                          y            test_db    12.4    12.4                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16520    test_db    DATABASE     �   CREATE DATABASE test_db WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE test_db;
                postgres    false            �            1259    16532    link_forward    TABLE     �   CREATE TABLE public.link_forward (
    id bigint NOT NULL,
    created timestamp(0) without time zone NOT NULL,
    link_id integer,
    user_id character varying
);
     DROP TABLE public.link_forward;
       public         heap    postgres    false            �            1259    16540    link_forward_id_seq    SEQUENCE     |   CREATE SEQUENCE public.link_forward_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.link_forward_id_seq;
       public          postgres    false    204                       0    0    link_forward_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.link_forward_id_seq OWNED BY public.link_forward.id;
          public          postgres    false    205            �            1259    16521    links    TABLE       CREATE TABLE public.links (
    id bigint NOT NULL,
    created timestamp(0) without time zone NOT NULL,
    updated timestamp(0) without time zone,
    deleted timestamp(0) without time zone,
    original_link character varying(256),
    short_link character varying(256)
);
    DROP TABLE public.links;
       public         heap    postgres    false            �            1259    16529    links_id_seq    SEQUENCE     u   CREATE SEQUENCE public.links_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.links_id_seq;
       public          postgres    false    202                       0    0    links_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.links_id_seq OWNED BY public.links.id;
          public          postgres    false    203            �
           2604    16542    link_forward id    DEFAULT     r   ALTER TABLE ONLY public.link_forward ALTER COLUMN id SET DEFAULT nextval('public.link_forward_id_seq'::regclass);
 >   ALTER TABLE public.link_forward ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204            �
           2604    16531    links id    DEFAULT     d   ALTER TABLE ONLY public.links ALTER COLUMN id SET DEFAULT nextval('public.links_id_seq'::regclass);
 7   ALTER TABLE public.links ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    203    202                      0    16532    link_forward 
   TABLE DATA           E   COPY public.link_forward (id, created, link_id, user_id) FROM stdin;
    public          postgres    false    204   �                 0    16521    links 
   TABLE DATA           Y   COPY public.links (id, created, updated, deleted, original_link, short_link) FROM stdin;
    public          postgres    false    202   }                  0    0    link_forward_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.link_forward_id_seq', 8, true);
          public          postgres    false    205                       0    0    links_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.links_id_seq', 21, true);
          public          postgres    false    203            �
           2606    16539    link_forward link_forward_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.link_forward
    ADD CONSTRAINT link_forward_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.link_forward DROP CONSTRAINT link_forward_pkey;
       public            postgres    false    204            �
           2606    16528    links links_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.links
    ADD CONSTRAINT links_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.links DROP CONSTRAINT links_pkey;
       public            postgres    false    202               �   x��α��0�ت�p��Z~�迄S�?w�ӝ}�K#� _'�]�=��5�6� ��&���:�:U
��B7��u��d\�@*8�5{���(��z��[�ד�;��'�;ܾ1�[�vȱ\��'�#�&�t��kI�c��b�q��c\�#�Ƚl3!��y��a�\ߘ�ޞh�n"dX��ط�9���C��K�秔��gpu         �  x����N�@��OA�R��w�S"-�J��P�XqP�dx%�F[�6[Q��Q`�kg�rutΧ{�̐ Iؒ�E��Fy�l�,#��"͖� "@�CiT�BJ[�`�g�o�n���bv����R�8���|�	D�/8��"�N�6��3Y,&��3\$m�I?ٙu��aϠ�"<L��0Ţ��~e��������=5��F����������ӟ�Ϗ�ögR��3~�몋�E��_� V�hd� ��ˀ��z�`O�9�=	 �rp���T*�D߸�Y+[$z۱^Y�n�ֆ�!���i@�;�՗Z�4����P˃]}y
�5zkC��CW5������+���ag�����!�y����'��Q�O���G� ɽ�Ż�֪��Ϻ�9r�o���*3��Ó� x�25t     