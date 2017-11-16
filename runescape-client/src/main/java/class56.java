import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("bb")
public class class56 {
   @ObfuscatedName("b")
   static Applet field630;
   @ObfuscatedName("s")
   public static String field629;
   @ObfuscatedName("u")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   static IndexedSprite[] field632;

   static {
      field630 = null;
      field629 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-420936823"
   )
   static Class method775(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILcx;ZI)I",
      garbageValue = "-1032388050"
   )
   static int method773(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class82.intStackSize -= 2;
         var3 = class82.intStack[class82.intStackSize];
         int var4 = class82.intStack[class82.intStackSize + 1];
         if(!Client.field1094) {
            Client.field930 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class82.intStack[++class82.intStackSize - 1] = Client.field930;
         return 1;
      } else if(var0 == 5506) {
         class82.intStack[++class82.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class82.intStack[--class82.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field902 = var3;
         return 1;
      } else if(var0 == 5531) {
         class82.intStack[++class82.intStackSize - 1] = Client.field902;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-88"
   )
   static void method770(int var0) {
      if(var0 == -1 && !Client.field1084) {
         WorldMapData.method319();
      } else if(var0 != -1 && var0 != Client.field1083 && Client.field945 != 0 && !Client.field1084) {
         RSCanvas.method744(2, class45.indexTrack1, var0, 0, Client.field945, false);
      }

      Client.field1083 = var0;
   }
}
