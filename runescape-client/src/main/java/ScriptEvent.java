import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   public static Buffer field858;
   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("fm")
   static byte[][] field856;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   class219 field844;
   @ObfuscatedName("w")
   Object[] field849;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1712133579
   )
   int field847;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -749393269
   )
   int field848;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   Widget field855;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1817595007
   )
   int field854;
   @ObfuscatedName("x")
   String field853;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1540056343
   )
   int field851;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -259873379
   )
   int field845;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -620532887
   )
   int field852;
   @ObfuscatedName("s")
   boolean field846;

   public ScriptEvent() {
      this.field844 = class219.field2787;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "53"
   )
   public void method1098(Object[] var1) {
      this.field849 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lhy;B)V",
      garbageValue = "-80"
   )
   public void method1096(class219 var1) {
      this.field844 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;S)Ljava/lang/String;",
      garbageValue = "237"
   )
   static String method1095(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class152) {
         class152 var2 = (class152)var0;
         var1 = var2.field2212 + " | ";
         var0 = var2.field2215;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lfx;",
      garbageValue = "561191866"
   )
   public static Timer method1090() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Lhj;I)Z",
      garbageValue = "-1913184343"
   )
   static boolean method1097(Widget var0) {
      if(Client.field1084) {
         if(class25.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "397781024"
   )
   public static void method1092(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.getFile(var1);
      int var6 = var0.getChild(var5, var2);
      CombatInfoListHolder.method1691(var0, var5, var6, var3, var4);
   }
}
