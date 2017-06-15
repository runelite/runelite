import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
public class class291 extends Node {
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 666026731
   )
   int field3864;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2113020627
   )
   int field3868;
   @ObfuscatedName("j")
   boolean field3869;
   @ObfuscatedName("at")
   int[] field3870;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -263960401
   )
   int field3873;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 83984779
   )
   int field3874;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -537387075
   )
   int field3875;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -931748307
   )
   int field3876;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1784139087
   )
   int field3877;
   @ObfuscatedName("am")
   boolean field3879;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -283801039
   )
   int field3880;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1829248841
   )
   int field3881;
   @ObfuscatedName("ah")
   String field3882;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 702627071
   )
   int field3883;
   @ObfuscatedName("ag")
   String field3884;
   @ObfuscatedName("aq")
   String field3885;
   @ObfuscatedName("as")
   String field3886;
   @ObfuscatedName("an")
   String field3887;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -491880769
   )
   int field3889;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1217751941
   )
   int field3890;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 402582313
   )
   int field3891;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -341861015
   )
   int field3892;
   @ObfuscatedName("ad")
   String field3893;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 938334927
   )
   int field3895;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1145531556"
   )
   void method5225() {
      if(this.field3884.length() > 40) {
         this.field3884 = this.field3884.substring(0, 40);
      }

      if(this.field3885.length() > 40) {
         this.field3885 = this.field3885.substring(0, 40);
      }

      if(this.field3886.length() > 10) {
         this.field3886 = this.field3886.substring(0, 10);
      }

      if(this.field3887.length() > 10) {
         this.field3887 = this.field3887.substring(0, 10);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-417786707"
   )
   public int method5228() {
      byte var1 = 38;
      int var2 = var1 + VertexNormal.method2491(this.field3884);
      var2 += VertexNormal.method2491(this.field3885);
      var2 += VertexNormal.method2491(this.field3886);
      var2 += VertexNormal.method2491(this.field3887);
      var2 += VertexNormal.method2491(this.field3882);
      var2 += VertexNormal.method2491(this.field3893);
      return var2;
   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class291(boolean var1) {
      this.field3870 = new int[3];
      if(WidgetNode.field812.startsWith("win")) {
         this.field3868 = 1;
      } else if(WidgetNode.field812.startsWith("mac")) {
         this.field3868 = 2;
      } else if(WidgetNode.field812.startsWith("linux")) {
         this.field3868 = 3;
      } else {
         this.field3868 = 4;
      }

      String var2;
      try {
         var2 = System.getProperty("os.arch").toLowerCase();
      } catch (Exception var13) {
         var2 = "";
      }

      String var3;
      try {
         var3 = System.getProperty("os.version").toLowerCase();
      } catch (Exception var12) {
         var3 = "";
      }

      String var4 = "Unknown";
      String var5 = "1.1";

      try {
         var4 = System.getProperty("java.vendor");
         var5 = System.getProperty("java.version");
      } catch (Exception var11) {
         ;
      }

      if(!var2.startsWith("amd64") && !var2.startsWith("x86_64")) {
         this.field3869 = false;
      } else {
         this.field3869 = true;
      }

      if(this.field3868 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3874 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3874 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3874 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3874 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3874 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3874 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3874 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3874 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3874 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3874 = 10;
         }
      } else if(this.field3868 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3874 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3874 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3874 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3874 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3874 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3874 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3874 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3875 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3875 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3875 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3875 = 5;
      } else {
         this.field3875 = 4;
      }

      int var6 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var6;
         }
      } catch (Exception var16) {
         ;
      }

      this.field3876 = var7;
      var6 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var15) {
         ;
      }

      this.field3877 = var7;
      var6 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var6 < var5.length()) {
            var8 = var5.charAt(var6);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var6;
         }
      } catch (Exception var14) {
         ;
      }

      this.field3892 = var7;
      this.field3879 = false;
      Runtime.getRuntime();
      this.field3880 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.field3876 > 3) {
         this.field3881 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3881 = 0;
      }

      this.field3891 = 0;
      if(this.field3884 == null) {
         this.field3884 = "";
      }

      if(this.field3885 == null) {
         this.field3885 = "";
      }

      if(this.field3886 == null) {
         this.field3886 = "";
      }

      if(this.field3887 == null) {
         this.field3887 = "";
      }

      if(this.field3882 == null) {
         this.field3882 = "";
      }

      if(this.field3893 == null) {
         this.field3893 = "";
      }

      this.method5225();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-106"
   )
   public void method5233(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3868);
      var1.putByte(this.field3869?1:0);
      var1.putByte(this.field3874);
      var1.putByte(this.field3875);
      var1.putByte(this.field3876);
      var1.putByte(this.field3877);
      var1.putByte(this.field3892);
      var1.putByte(this.field3879?1:0);
      var1.putShort(this.field3880);
      var1.putByte(this.field3881);
      var1.put24bitInt(this.field3891);
      var1.putShort(this.field3883);
      var1.method3025(this.field3884);
      var1.method3025(this.field3885);
      var1.method3025(this.field3886);
      var1.method3025(this.field3887);
      var1.putByte(this.field3889);
      var1.putShort(this.field3864);
      var1.method3025(this.field3882);
      var1.method3025(this.field3893);
      var1.putByte(this.field3890);
      var1.putByte(this.field3873);

      for(int var2 = 0; var2 < this.field3870.length; ++var2) {
         var1.putInt(this.field3870[var2]);
      }

      var1.putInt(this.field3895);
   }
}
