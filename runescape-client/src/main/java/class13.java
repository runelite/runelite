import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class13 {
   @ObfuscatedName("gi")
   @ObfuscatedGetter(
      intValue = 1594132879
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("m")
   public static Comparator field282;
   @ObfuscatedName("e")
   public static Comparator field283;
   @ObfuscatedName("t")
   public static Comparator field285;
   @ObfuscatedName("fk")
   @Export("mapRegions")
   @Hook("mapRegionsChanged")
   static int[] mapRegions;
   @ObfuscatedName("p")
   public final List field287;
   @ObfuscatedName("w")
   public static Comparator field288;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1913019937
   )
   static int field289;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IIIZI)V",
      garbageValue = "-1748316856"
   )
   public static void method75(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2517 = 1;
      class203.field2518 = var0;
      class203.field2519 = var1;
      class29.field438 = var2;
      class182.field2455 = var3;
      class88.field1384 = var4;
      CollisionData.field2304 = 10000;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2022457418"
   )
   static final int method76(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "1077178263"
   )
   public void method79(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field287, var1);
      } else {
         Collections.sort(this.field287, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field287 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field287.add(new class14(var1, var5, var3));
      }

   }

   static {
      field282 = new class19();
      new class12();
      field283 = new class17();
      field285 = new class18();
      field288 = new class15();
   }
}
