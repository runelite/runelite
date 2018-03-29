import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ai")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 165230499
   )
   @Export("worldMapRegionWidth")
   int worldMapRegionWidth;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -131982961
   )
   @Export("worldMapRegionHeight")
   int worldMapRegionHeight;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -254202691
   )
   @Export("worldMapRegionX")
   int worldMapRegionX;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 251093751
   )
   @Export("worldMapRegionY")
   int worldMapRegionY;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lag;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lag;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-51"
   )
   static synchronized byte[] method271(int var0) {
      return class195.method3742(var0, false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "121"
   )
   @Export("loadClassFromDescriptor")
   public static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILjj;IB)V",
      garbageValue = "22"
   )
   static void method269(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class80 var5 = new class80();
      var5.field1265 = var0;
      var5.field1264 = var1 * 128;
      var5.field1255 = var2 * 128;
      int var6 = var3.width;
      int var7 = var3.length;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.length;
         var7 = var3.width;
      }

      var5.field1256 = (var6 + var1) * 128;
      var5.field1257 = (var7 + var2) * 128;
      var5.field1259 = var3.ambientSoundId;
      var5.field1258 = var3.int4 * 128;
      var5.field1266 = var3.int5;
      var5.field1262 = var3.int6;
      var5.field1263 = var3.field3634;
      if(var3.impostorIds != null) {
         var5.field1252 = var3;
         var5.method1732();
      }

      class80.field1261.addFront(var5);
      if(var5.field1263 != null) {
         var5.field1253 = var5.field1266 + (int)(Math.random() * (double)(var5.field1262 - var5.field1266));
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1197141515"
   )
   public static void method272() {
      class278.field3545.reset();
   }
}
