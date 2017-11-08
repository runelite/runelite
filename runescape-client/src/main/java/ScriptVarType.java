import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("ScriptVarType")
public class ScriptVarType implements RSEnum, class293 {
   @ObfuscatedName("oe")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   static SpritePixels field85;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   public static final ScriptVarType field77;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field56;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field49;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field50;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field159;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field153;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field53;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field230;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field103;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field58;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field57;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field236;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field59;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field60;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field61;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field62;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field51;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field162;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field174;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field133;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field67;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field68;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field69;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field70;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field71;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field72;
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field101;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field74;
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field75;
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field76;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field177;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field78;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field129;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field80;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field63;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field143;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field200;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field84;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field47;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field173;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field131;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field88;
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field89;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field90;
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field91;
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field92;
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field220;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field156;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field95;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field96;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field141;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field98;
   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field99;
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field94;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field130;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field116;
   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field186;
   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field104;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field105;
   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field106;
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field83;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field102;
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field192;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field110;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field111;
   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field188;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field113;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field114;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field115;
   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field73;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field117;
   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field118;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field119;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field120;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field121;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field122;
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field123;
   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field124;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field125;
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field126;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field86;
   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field128;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field145;
   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field138;
   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field79;
   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field132;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field187;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field134;
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field135;
   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field100;
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field137;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field108;
   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field139;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field140;
   @ObfuscatedName("cq")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field183;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field142;
   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field127;
   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field144;
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field180;
   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field146;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field147;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field148;
   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field179;
   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field150;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field151;
   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field152;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field175;
   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field154;
   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field182;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field222;
   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field65;
   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field158;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field64;
   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field160;
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field161;
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field136;
   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field163;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field164;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field216;
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field166;
   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field149;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field168;
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field169;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field170;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field171;
   @ObfuscatedName("do")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field172;
   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field48;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field232;
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field81;
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field176;
   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field197;
   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field178;
   @ObfuscatedName("ea")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field55;
   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field181;
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field112;
   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field93;
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field165;
   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field184;
   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field185;
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field210;
   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field87;
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field155;
   @ObfuscatedName("eo")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field189;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field190;
   @ObfuscatedName("ek")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field191;
   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field109;
   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field193;
   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field194;
   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field195;
   @ObfuscatedName("ey")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field196;
   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field107;
   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field198;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field199;
   @ObfuscatedName("et")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field52;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field201;
   @ObfuscatedName("ee")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field202;
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field203;
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field204;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field205;
   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field206;
   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field207;
   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field208;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field209;
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field157;
   @ObfuscatedName("fk")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field211;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field212;
   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field213;
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field214;
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field215;
   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field226;
   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field54;
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field218;
   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field219;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field82;
   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field221;
   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field97;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field223;
   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field224;
   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field225;
   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field167;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field227;
   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field228;
   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field229;
   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field217;
   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      signature = "Lp;"
   )
   static final ScriptVarType field231;
   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "[Lp;"
   )
   static ScriptVarType[] field234;
   @ObfuscatedName("jp")
   @ObfuscatedGetter(
      intValue = 701281191
   )
   @Export("menuWidth")
   static int menuWidth;
   @ObfuscatedName("gb")
   @ObfuscatedGetter(
      intValue = 1797759817
   )
   @Export("id")
   final int id;
   @ObfuscatedName("gk")
   @Export("typeChar")
   final char typeChar;

   static {
      field77 = new ScriptVarType(0, 'i', BaseVarType.INTEGER, Integer.valueOf(0), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12, class1.field6});
      field56 = new ScriptVarType(1, '1', BaseVarType.INTEGER, Integer.valueOf(0), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12, class1.field6});
      field49 = new ScriptVarType(2, '2', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1});
      field50 = new ScriptVarType(3, ':', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field159 = new ScriptVarType(4, ';', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field153 = new ScriptVarType(5, '@', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field53 = new ScriptVarType(6, 'A', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field230 = new ScriptVarType(7, 'C', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field103 = new ScriptVarType(8, 'H', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field58 = new ScriptVarType(9, 'I', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field57 = new ScriptVarType(10, 'K', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field236 = new ScriptVarType(11, 'M', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field59 = new ScriptVarType(12, 'N', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field60 = new ScriptVarType(13, 'O', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[0]);
      field61 = new ScriptVarType(14, 'P', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field62 = new ScriptVarType(15, 'Q', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1});
      field51 = new ScriptVarType(16, 'R', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field162 = new ScriptVarType(17, 'S', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field6, class1.field12});
      field174 = new ScriptVarType(18, 'T', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field133 = new ScriptVarType(19, 'V', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field67 = new ScriptVarType(20, '^', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field68 = new ScriptVarType(21, '`', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field69 = new ScriptVarType(22, 'c', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12, class1.field6});
      field70 = new ScriptVarType(23, 'd', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field71 = new ScriptVarType(24, 'e', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field72 = new ScriptVarType(25, 'f', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field101 = new ScriptVarType(26, 'g', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field74 = new ScriptVarType(27, 'h', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3});
      field75 = new ScriptVarType(28, 'j', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field76 = new ScriptVarType(29, 'k', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field177 = new ScriptVarType(30, 'l', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field78 = new ScriptVarType(31, 'm', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field129 = new ScriptVarType(32, 'n', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field6, class1.field12});
      field80 = new ScriptVarType(33, 'o', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12, class1.field6});
      field63 = new ScriptVarType(34, 'p', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field12});
      field143 = new ScriptVarType(35, 'r', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field6});
      field200 = new ScriptVarType(36, 's', BaseVarType.STRING, "", new class1[]{class1.field9, class1.field2, class1.field3, class1.field4, class1.field12});
      field84 = new ScriptVarType(37, 't', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field47 = new ScriptVarType(38, 'u', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field12});
      field173 = new ScriptVarType(39, 'v', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field131 = new ScriptVarType(40, 'x', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field88 = new ScriptVarType(41, 'y', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field89 = new ScriptVarType(42, 'z', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field90 = new ScriptVarType(43, '|', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field91 = new ScriptVarType(44, '€', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field92 = new ScriptVarType(45, 'ƒ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3});
      field220 = new ScriptVarType(46, '‡', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field156 = new ScriptVarType(47, '‰', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field95 = new ScriptVarType(48, 'Š', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field96 = new ScriptVarType(49, 'Œ', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field4, class1.field12, class1.field6});
      field141 = new ScriptVarType(51, 'š', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field98 = new ScriptVarType(53, '¡', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field99 = new ScriptVarType(54, '¢', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3});
      field94 = new ScriptVarType(55, '£', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field130 = new ScriptVarType(56, '§', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field3, class1.field12});
      field116 = new ScriptVarType(57, '«', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field186 = new ScriptVarType(58, '®', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field104 = new ScriptVarType(59, 'µ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field105 = new ScriptVarType(60, '¶', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field106 = new ScriptVarType(61, 'Æ', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field83 = new ScriptVarType(62, '×', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field102 = new ScriptVarType(63, 'Þ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field192 = new ScriptVarType(64, 'á', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field110 = new ScriptVarType(65, 'æ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2});
      field111 = new ScriptVarType(66, 'é', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field188 = new ScriptVarType(67, 'í', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12});
      field113 = new ScriptVarType(68, 'î', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field4, class1.field12});
      field114 = new ScriptVarType(69, 'ó', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field115 = new ScriptVarType(70, 'ú', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field73 = new ScriptVarType(71, 'û', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field4, class1.field2, class1.field12, class1.field6});
      field117 = new ScriptVarType(72, 'Î', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12});
      field118 = new ScriptVarType(73, 'J', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12, class1.field6});
      field119 = new ScriptVarType(74, 'Ð', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field12, class1.field6});
      field120 = new ScriptVarType(75, '¤', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3});
      field121 = new ScriptVarType(76, '¥', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3});
      field122 = new ScriptVarType(77, 'è', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field6});
      field123 = new ScriptVarType(78, '¹', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3});
      field124 = new ScriptVarType(79, '°', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3});
      field125 = new ScriptVarType(80, 'ì', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field3});
      field126 = new ScriptVarType(81, 'ë', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3});
      field86 = new ScriptVarType(83, 'þ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field3});
      field128 = new ScriptVarType(84, 'ý', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field145 = new ScriptVarType(85, 'ÿ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field138 = new ScriptVarType(86, 'õ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field79 = new ScriptVarType(87, 'ô', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field132 = new ScriptVarType(88, 'ö', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field187 = new ScriptVarType(89, 'ò', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field134 = new ScriptVarType(90, 'Ü', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3});
      field135 = new ScriptVarType(91, 'ù', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3});
      field100 = new ScriptVarType(92, 'ï', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3});
      field137 = new ScriptVarType(93, '¯', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3});
      field108 = new ScriptVarType(94, 'ê', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field139 = new ScriptVarType(95, 'ð', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field140 = new ScriptVarType(96, 'å', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field183 = new ScriptVarType(97, 'a', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field142 = new ScriptVarType(98, 'F', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field127 = new ScriptVarType(99, 'L', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field144 = new ScriptVarType(100, '©', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field180 = new ScriptVarType(101, 'Ý', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field146 = new ScriptVarType(102, '¬', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field147 = new ScriptVarType(103, 'ø', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field148 = new ScriptVarType(104, 'ä', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field179 = new ScriptVarType(105, 'ã', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field150 = new ScriptVarType(106, 'â', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field151 = new ScriptVarType(107, 'à', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field152 = new ScriptVarType(108, 'À', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field175 = new ScriptVarType(109, 'Ò', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field154 = new ScriptVarType(110, 'Ï', BaseVarType.LONG, Long.valueOf(0L), new class1[]{class1.field9, class1.field2, class1.field3, class1.field4, class1.field12, class1.field6});
      field182 = new ScriptVarType(111, 'Ì', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field222 = new ScriptVarType(112, 'É', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field65 = new ScriptVarType(113, 'Ê', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field6, class1.field3, class1.field12});
      field158 = new ScriptVarType(114, '÷', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3, class1.field4, class1.field12, class1.field6});
      field64 = new ScriptVarType(115, '¼', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field3});
      field160 = new ScriptVarType(116, '½', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field3});
      field161 = new ScriptVarType(117, '•', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field3, class1.field12});
      field136 = new ScriptVarType(118, 'Â', BaseVarType.LONG, Long.valueOf(-1L), new class1[]{class1.field9, class1.field2, class1.field4, class1.field12, class1.field6});
      field163 = new ScriptVarType(119, 'Ã', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field164 = new ScriptVarType(120, 'Å', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field216 = new ScriptVarType(121, 'Ë', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field166 = new ScriptVarType(122, 'Í', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field149 = new ScriptVarType(123, 'Õ', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field168 = new ScriptVarType(124, '²', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field169 = new ScriptVarType(125, 'ª', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field170 = new ScriptVarType(126, '\u0000', BaseVarType.INTEGER, Integer.valueOf(0), new class1[]{class1.field9, class1.field1, class1.field2, class1.field4, class1.field6, class1.field3, class1.field12});
      field171 = new ScriptVarType(127, '\u0000', BaseVarType.INTEGER, Integer.valueOf(-1), "", new class1[]{class1.field9, class1.field1, class1.field2, class1.field6, class1.field3, class1.field12});
      field172 = new ScriptVarType(128, '\u0000', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field1, class1.field2, class1.field3});
      field48 = new ScriptVarType(200, 'X', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[0]);
      field232 = new ScriptVarType(201, 'W', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[0]);
      field81 = new ScriptVarType(202, 'b', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field176 = new ScriptVarType(203, 'B', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field197 = new ScriptVarType(204, '4', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field178 = new ScriptVarType(205, 'w', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field55 = new ScriptVarType(206, 'q', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field181 = new ScriptVarType(207, '0', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9, class1.field3});
      field112 = new ScriptVarType(208, '6', BaseVarType.INTEGER, Integer.valueOf(-1), new class1[]{class1.field9});
      field93 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '#');
      field165 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '(');
      field184 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '%');
      field185 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '&');
      field210 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), ')');
      field87 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '3');
      field155 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '5');
      field189 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '7');
      field190 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '8');
      field191 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '9');
      field109 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'D');
      field193 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'G');
      field194 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'U');
      field195 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Á');
      field196 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Z');
      field107 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '~');
      field198 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '±');
      field199 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '»');
      field52 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '¿');
      field201 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ç');
      field202 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ø');
      field203 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ñ');
      field204 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'ñ');
      field205 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ù');
      field206 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'ß');
      field207 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'E');
      field208 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Y');
      field209 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ä');
      field157 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'ü');
      field211 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ú');
      field212 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Û');
      field213 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ó');
      field214 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'È');
      field215 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ô');
      field226 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '¾');
      field54 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'Ö');
      field218 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '³');
      field219 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '·');
      field82 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '\u0000');
      field221 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '\u0000');
      field97 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '\u0000');
      field223 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), 'º');
      field224 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '\u0000');
      field225 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '\u0000');
      field167 = new ScriptVarType(BaseVarType.INTEGER, Integer.valueOf(-1), '\u0000');
      field227 = new ScriptVarType((BaseVarType)null, Integer.valueOf(-1), '!');
      field228 = new ScriptVarType((BaseVarType)null, Integer.valueOf(-1), '$');
      field229 = new ScriptVarType((BaseVarType)null, Integer.valueOf(-1), '?');
      field217 = new ScriptVarType((BaseVarType)null, Integer.valueOf(-1), 'ç');
      field231 = new ScriptVarType((BaseVarType)null, Integer.valueOf(-1), '*');
   }

   @ObfuscatedSignature(
      signature = "(ICLg;Ljava/lang/Object;Ljava/lang/String;[Ls;)V"
   )
   ScriptVarType(int var1, char var2, BaseVarType var3, Object var4, String var5, class1[] var6) {
      this.id = var1;
      this.typeChar = var2;
      if(var5 != null && var5.length() > 0) {
         ;
      }

      method21(this);
   }

   @ObfuscatedSignature(
      signature = "(ICLg;Ljava/lang/Object;[Ls;)V"
   )
   ScriptVarType(int var1, char var2, BaseVarType var3, Object var4, class1[] var5) {
      this(var1, var2, var3, var4, (String)null, var5);
   }

   @ObfuscatedSignature(
      signature = "(Lg;Ljava/lang/Object;C)V"
   )
   ScriptVarType(BaseVarType var1, Object var2, char var3) {
      this(-1, var3, var1, var2, new class1[0]);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "6"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;ZII)V",
      garbageValue = "-1037668974"
   )
   static void method27(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class90.field1440) {
         if(var3 == 4) {
            class90.loginIndex = 4;
         }

      } else {
         class90.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4265("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         label156: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               int var7 = var6.getWidth();
               int var8 = var6.getHeight();
               int[] var9 = new int[var8 * var7];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label156;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class90.field1427 = var5;
         class8.field250 = class90.field1427.method5163();
         if((Client.flags & 536870912) != 0) {
            class29.logoSprite = InvType.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class29.logoSprite = InvType.getSprite(var1, "logo", "");
         }

         class90.field1414 = InvType.getSprite(var1, "titlebox", "");
         World.field1293 = InvType.getSprite(var1, "titlebutton", "");
         class90.field1415 = class219.method4135(var1, "runes", "");
         class252.titlemuteSprite = class219.method4135(var1, "title_mute", "");
         class90.field1417 = InvType.getSprite(var1, "options_radio_buttons,0", "");
         class90.field1418 = InvType.getSprite(var1, "options_radio_buttons,4", "");
         class29.field430 = InvType.getSprite(var1, "options_radio_buttons,2", "");
         class90.field1419 = InvType.getSprite(var1, "options_radio_buttons,6", "");
         GZipDecompressor.field2325 = class90.field1417.originalWidth;
         class41.field586 = class90.field1417.height;
         class294.field3916 = new int[256];

         int var11;
         for(var11 = 0; var11 < 64; ++var11) {
            class294.field3916[var11] = var11 * 262144;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class294.field3916[var11 + 64] = var11 * 1024 + 16711680;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class294.field3916[var11 + 128] = var11 * 4 + 16776960;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class294.field3916[var11 + 192] = 16777215;
         }

         class17.field322 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class17.field322[var11] = var11 * 1024;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class17.field322[var11 + 64] = var11 * 4 + 65280;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class17.field322[var11 + 128] = var11 * 262144 + 65535;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class17.field322[var11 + 192] = 16777215;
         }

         class219.field2789 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class219.field2789[var11] = var11 * 4;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class219.field2789[var11 + 64] = var11 * 262144 + 255;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class219.field2789[var11 + 128] = var11 * 1024 + 16711935;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class219.field2789[var11 + 192] = 16777215;
         }

         Signlink.field2231 = new int[256];
         Frames.field2125 = new int['耀'];
         class164.field2312 = new int['耀'];
         class182.method3534((IndexedSprite)null);
         class90.field1425 = new int['耀'];
         World.field1285 = new int['耀'];
         if(var2) {
            class90.username = "";
            class90.password = "";
         }

         class41.field585 = 0;
         DState.field2346 = "";
         class90.field1438 = true;
         class90.worldSelectShown = false;
         if(!class70.preferences.muted) {
            class8.method42(2, class37.indexTrack1, "scape main", "", 255, false);
         } else {
            class164.method3140(2);
         }

         class34.sendConInfo(false);
         class90.field1440 = true;
         class90.field1413 = (Timer.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1413 + 202;
         class227.field3145 = class90.loginWindowX + 180;
         class90.field1427.method5172(class90.field1413, 0);
         class8.field250.method5172(class90.field1413 + 382, 0);
         class29.logoSprite.method5147(class90.field1413 + 382 - class29.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lp;I)V",
      garbageValue = "-1976433895"
   )
   static void method21(ScriptVarType var0) {
      if(field234 == null) {
         field234 = new ScriptVarType[256];
      }

      field234[class28.method246(var0.typeChar) & 255] = var0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2147423003"
   )
   public static void method29() {
      try {
         if(class203.field2500 == 1) {
            int var0 = class203.field2499.method3859();
            if(var0 > 0 && class203.field2499.method3877()) {
               var0 -= class36.field523;
               if(var0 < 0) {
                  var0 = 0;
               }

               class203.field2499.method3834(var0);
               return;
            }

            class203.field2499.method3787();
            class203.field2499.method3785();
            if(ContextMenuRow.field1392 != null) {
               class203.field2500 = 2;
            } else {
               class203.field2500 = 0;
            }

            Ignore.field863 = null;
            class203.field2504 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class203.field2499.method3787();
         class203.field2500 = 0;
         Ignore.field863 = null;
         class203.field2504 = null;
         ContextMenuRow.field1392 = null;
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(Lbk;IIB)V",
      garbageValue = "17"
   )
   static void method28(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = NPCComposition.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1243 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1245 = 0;
         }

         if(var3 == 2) {
            var0.field1245 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || NPCComposition.getAnimation(var1).forcedPriority >= NPCComposition.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1243 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1245 = 0;
         var0.field1213 = var0.queueSize;
      }

   }
}
