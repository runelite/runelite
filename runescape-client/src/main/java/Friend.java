import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("d")
   String field160;
   @ObfuscatedName("j")
   boolean field161;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2072170955
   )
   int field162;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 495814735
   )
   @Export("world")
   int world;
   @ObfuscatedName("n")
   boolean field164;
   @ObfuscatedName("q")
   @Export("name")
   String name;
   @ObfuscatedName("ig")
   @ObfuscatedGetter(
      intValue = -1417030217
   )
   static int field166;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "974005956"
   )
   static final void method176(Widget var0, int var1, int var2) {
      if(Client.field523 == null && !Client.isMenuOpen) {
         if(null != var0 && class214.method3986(var0) != null) {
            Client.field523 = var0;
            Client.field530 = class214.method3986(var0);
            Client.field480 = var1;
            Client.field369 = var2;
            class45.field922 = 0;
            Client.field492 = false;
            int var3 = Buffer.method2893();
            if(var3 != -1) {
               class152.method2813(var3);
            }

         }
      }
   }

   @ObfuscatedName("ef")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Ljava/lang/String;",
      garbageValue = "366151898"
   )
   static String method177(Widget var0) {
      int var2 = class196.method3614(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(null != var0.field2306 && var0.field2306.trim().length() != 0?var0.field2306:null);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1999709772"
   )
   public static int method178(int var0) {
      return var0 >> 11 & 63;
   }
}
