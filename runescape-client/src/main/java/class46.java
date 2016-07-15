import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
@Implements("KitDefinition")
public class class46 extends class207 {
   @ObfuscatedName("o")
   short[] field1059;
   @ObfuscatedName("l")
   static class170 field1060;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1534116161
   )
   public static int field1061;
   @ObfuscatedName("h")
   public static class196 field1062 = new class196(64);
   @ObfuscatedName("e")
   static class170 field1063;
   @ObfuscatedName("a")
   int[] field1064;
   @ObfuscatedName("u")
   short[] field1065;
   @ObfuscatedName("b")
   short[] field1066;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1208856505
   )
   public int field1067 = -1;
   @ObfuscatedName("p")
   short[] field1068;
   @ObfuscatedName("i")
   int[] field1069 = new int[]{-1, -1, -1, -1, -1};
   @ObfuscatedName("q")
   public boolean field1070 = false;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;B)V",
      garbageValue = "2"
   )
   void method984(class122 var1) {
      while(true) {
         int var2 = var1.method2610();
         if(var2 == 0) {
            return;
         }

         this.method985(var1, var2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "-1622273947"
   )
   void method985(class122 var1, int var2) {
      if(var2 == 1) {
         this.field1067 = var1.method2610();
      } else {
         int var3;
         int var4;
         if(var2 == 2) {
            var3 = var1.method2610();
            this.field1064 = new int[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1064[var4] = var1.method2612();
            }
         } else if(var2 == 3) {
            this.field1070 = true;
         } else if(var2 == 40) {
            var3 = var1.method2610();
            this.field1066 = new short[var3];
            this.field1065 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1066[var4] = (short)var1.method2612();
               this.field1065[var4] = (short)var1.method2612();
            }
         } else if(var2 == 41) {
            var3 = var1.method2610();
            this.field1059 = new short[var3];
            this.field1068 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1059[var4] = (short)var1.method2612();
               this.field1068[var4] = (short)var1.method2612();
            }
         } else if(var2 >= 60 && var2 < 70) {
            this.field1069[var2 - 60] = var1.method2612();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1076950093"
   )
   @Export("ready")
   public boolean method986() {
      if(this.field1064 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field1064.length; ++var2) {
            if(!field1060.method3344(this.field1064[var2], 0)) {
               var1 = false;
            }
         }

         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Lclass103;",
      garbageValue = "-4"
   )
   public class103 method987() {
      class103[] var1 = new class103[5];
      int var2 = 0;

      for(int var3 = 0; var3 < 5; ++var3) {
         if(this.field1069[var3] != -1) {
            var1[var2++] = class103.method2311(field1060, this.field1069[var3], 0);
         }
      }

      class103 var5 = new class103(var1, var2);
      int var4;
      if(this.field1066 != null) {
         for(var4 = 0; var4 < this.field1066.length; ++var4) {
            var5.method2350(this.field1066[var4], this.field1065[var4]);
         }
      }

      if(null != this.field1059) {
         for(var4 = 0; var4 < this.field1059.length; ++var4) {
            var5.method2301(this.field1059[var4], this.field1068[var4]);
         }
      }

      return var5;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "30"
   )
   public boolean method988() {
      boolean var1 = true;

      for(int var2 = 0; var2 < 5; ++var2) {
         if(this.field1069[var2] != -1 && !field1060.method3344(this.field1069[var2], 0)) {
            var1 = false;
         }
      }

      return var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "-1688018257"
   )
   public static void method1008(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class151) {
               class151 var6 = (class151)var1;
               var5 = var6.field2274 + " | ";
               var4 = var6.field2273;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(var11 == null) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, 1 + var12);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(1 + var12, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(var0 != null) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class151.field2270) {
            return;
         }

         URL var3 = new URL(class151.field2270.getCodeBase(), "clienterror.ws?c=" + class151.field2271 + "&u=" + class221.field3209 + "&v1=" + class139.field2143 + "&v2=" + class216.field3190 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Lclass103;",
      garbageValue = "-99488818"
   )
   @Export("getModelData")
   public class103 method1013() {
      if(this.field1064 == null) {
         return null;
      } else {
         class103[] var1 = new class103[this.field1064.length];

         for(int var2 = 0; var2 < this.field1064.length; ++var2) {
            var1[var2] = class103.method2311(field1060, this.field1064[var2], 0);
         }

         class103 var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            var4 = new class103(var1, var1.length);
         }

         int var3;
         if(null != this.field1066) {
            for(var3 = 0; var3 < this.field1066.length; ++var3) {
               var4.method2350(this.field1066[var3], this.field1065[var3]);
            }
         }

         if(this.field1059 != null) {
            for(var3 = 0; var3 < this.field1059.length; ++var3) {
               var4.method2301(this.field1059[var3], this.field1068[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1703456778"
   )
   public static int method1014(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1693352488"
   )
   public static String method1015(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
