import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
public class class291 extends Node {
   @ObfuscatedName("am")
   String field3857;
   @ObfuscatedName("t")
   boolean field3858;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1556679641
   )
   int field3862;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 63686291
   )
   int field3863;
   @ObfuscatedName("au")
   String field3865;
   @ObfuscatedName("an")
   String field3866;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1980709401
   )
   int field3869;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1844566119
   )
   int field3872;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1193436557
   )
   int field3874;
   @ObfuscatedName("ad")
   boolean field3875;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 29494969
   )
   int field3876;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 398762941
   )
   int field3878;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 335578313
   )
   int field3879;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 318756167
   )
   int field3880;
   @ObfuscatedName("ao")
   String field3881;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2034528557
   )
   int field3882;
   @ObfuscatedName("ap")
   String field3883;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1087902975
   )
   int field3885;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1364838307
   )
   int field3886;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1721907535
   )
   int field3887;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1346966053
   )
   int field3888;
   @ObfuscatedName("as")
   String field3889;
   @ObfuscatedName("ab")
   int[] field3891;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1058243089
   )
   int field3892;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-997346058"
   )
   public int method5442() {
      byte var1 = 38;
      int var2 = var1 + class168.method3167(this.field3881);
      var2 += class168.method3167(this.field3857);
      var2 += class168.method3167(this.field3883);
      var2 += class168.method3167(this.field3889);
      var2 += class168.method3167(this.field3866);
      var2 += class168.method3167(this.field3865);
      return var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1635315706"
   )
   public void method5443(Buffer var1) {
      var1.putByte(6);
      var1.putByte(this.field3862);
      var1.putByte(this.field3858?1:0);
      var1.putByte(this.field3882);
      var1.putByte(this.field3876);
      var1.putByte(this.field3872);
      var1.putByte(this.field3863);
      var1.putByte(this.field3874);
      var1.putByte(this.field3875?1:0);
      var1.putShort(this.field3888);
      var1.putByte(this.field3878);
      var1.put24bitInt(this.field3879);
      var1.putShort(this.field3880);
      var1.method3192(this.field3881);
      var1.method3192(this.field3857);
      var1.method3192(this.field3883);
      var1.method3192(this.field3889);
      var1.putByte(this.field3886);
      var1.putShort(this.field3885);
      var1.method3192(this.field3866);
      var1.method3192(this.field3865);
      var1.putByte(this.field3887);
      var1.putByte(this.field3869);

      for(int var2 = 0; var2 < this.field3891.length; ++var2) {
         var1.putInt(this.field3891[var2]);
      }

      var1.putInt(this.field3892);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1702171328"
   )
   void method5444() {
      if(this.field3881.length() > 40) {
         this.field3881 = this.field3881.substring(0, 40);
      }

      if(this.field3857.length() > 40) {
         this.field3857 = this.field3857.substring(0, 40);
      }

      if(this.field3883.length() > 10) {
         this.field3883 = this.field3883.substring(0, 10);
      }

      if(this.field3889.length() > 10) {
         this.field3889 = this.field3889.substring(0, 10);
      }

   }

   @ObfuscatedSignature(
      signature = "(Z)V",
      garbageValue = "1"
   )
   public class291(boolean var1) {
      this.field3891 = new int[3];
      if(WallObject.field2113.startsWith("win")) {
         this.field3862 = 1;
      } else if(WallObject.field2113.startsWith("mac")) {
         this.field3862 = 2;
      } else if(WallObject.field2113.startsWith("linux")) {
         this.field3862 = 3;
      } else {
         this.field3862 = 4;
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
         this.field3858 = false;
      } else {
         this.field3858 = true;
      }

      if(this.field3862 == 1) {
         if(var3.indexOf("4.0") != -1) {
            this.field3882 = 1;
         } else if(var3.indexOf("4.1") != -1) {
            this.field3882 = 2;
         } else if(var3.indexOf("4.9") != -1) {
            this.field3882 = 3;
         } else if(var3.indexOf("5.0") != -1) {
            this.field3882 = 4;
         } else if(var3.indexOf("5.1") != -1) {
            this.field3882 = 5;
         } else if(var3.indexOf("5.2") != -1) {
            this.field3882 = 8;
         } else if(var3.indexOf("6.0") != -1) {
            this.field3882 = 6;
         } else if(var3.indexOf("6.1") != -1) {
            this.field3882 = 7;
         } else if(var3.indexOf("6.2") != -1) {
            this.field3882 = 9;
         } else if(var3.indexOf("6.3") != -1) {
            this.field3882 = 10;
         }
      } else if(this.field3862 == 2) {
         if(var3.indexOf("10.4") != -1) {
            this.field3882 = 20;
         } else if(var3.indexOf("10.5") != -1) {
            this.field3882 = 21;
         } else if(var3.indexOf("10.6") != -1) {
            this.field3882 = 22;
         } else if(var3.indexOf("10.7") != -1) {
            this.field3882 = 23;
         } else if(var3.indexOf("10.8") != -1) {
            this.field3882 = 24;
         } else if(var3.indexOf("10.9") != -1) {
            this.field3882 = 25;
         } else if(var3.indexOf("10.10") != -1) {
            this.field3882 = 26;
         }
      }

      if(var4.toLowerCase().indexOf("sun") != -1) {
         this.field3876 = 1;
      } else if(var4.toLowerCase().indexOf("microsoft") != -1) {
         this.field3876 = 2;
      } else if(var4.toLowerCase().indexOf("apple") != -1) {
         this.field3876 = 3;
      } else if(var4.toLowerCase().indexOf("oracle") != -1) {
         this.field3876 = 5;
      } else {
         this.field3876 = 4;
      }

      int var9 = 2;
      int var7 = 0;

      char var8;
      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var16) {
         ;
      }

      this.field3872 = var7;
      var9 = var5.indexOf(46, 2) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var8 - 48 + var7 * 10;
            ++var9;
         }
      } catch (Exception var15) {
         ;
      }

      this.field3863 = var7;
      var9 = var5.indexOf(95, 4) + 1;
      var7 = 0;

      try {
         while(var9 < var5.length()) {
            var8 = var5.charAt(var9);
            if(var8 < 48 || var8 > 57) {
               break;
            }

            var7 = var7 * 10 + (var8 - 48);
            ++var9;
         }
      } catch (Exception var14) {
         ;
      }

      this.field3874 = var7;
      this.field3875 = false;
      Runtime.getRuntime();
      this.field3888 = (int)((long)((new Random()).nextInt(31457280) + 230686720) / 1048576L) + 1;
      if(this.field3872 > 3) {
         this.field3878 = Runtime.getRuntime().availableProcessors();
      } else {
         this.field3878 = 0;
      }

      this.field3879 = 0;
      if(this.field3881 == null) {
         this.field3881 = "";
      }

      if(this.field3857 == null) {
         this.field3857 = "";
      }

      if(this.field3883 == null) {
         this.field3883 = "";
      }

      if(this.field3889 == null) {
         this.field3889 = "";
      }

      if(this.field3866 == null) {
         this.field3866 = "";
      }

      if(this.field3865 == null) {
         this.field3865 = "";
      }

      this.method5444();
   }
}
