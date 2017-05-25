import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class40 {
   @ObfuscatedName("ec")
   static Font field531;
   @ObfuscatedName("h")
   public static final class40 field532;
   @ObfuscatedName("u")
   public static final class40 field533;
   @ObfuscatedName("q")
   public static final class40 field534;
   @ObfuscatedName("g")
   public static final class40 field535;
   @ObfuscatedName("gr")
   @ObfuscatedGetter(
      intValue = -659604793
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("i")
   public static final class40 field538;
   @ObfuscatedName("ad")
   static Image field539;
   @ObfuscatedName("v")
   public final String field540;
   @ObfuscatedName("ai")
   public static BufferProvider field541;

   static {
      field538 = new class40("details");
      field532 = new class40("compositemap");
      field533 = new class40("compositetexture");
      field534 = new class40("area");
      field535 = new class40("labels");
   }

   class40(String var1) {
      this.field540 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2144508085"
   )
   public static void method554() {
      Sequence.field3596.reset();
      Sequence.field3599.reset();
   }

   @ObfuscatedName("gx")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1274674956"
   )
   static final void method555(int var0, int var1, int var2, int var3) {
      if(Client.field1016 == 1) {
         class228.field3148[Client.field999 / 100].method5207(Client.field997 - 8, Client.field998 - 8);
      }

      if(Client.field1016 == 2) {
         class228.field3148[Client.field999 / 100 + 4].method5207(Client.field997 - 8, Client.field998 - 8);
      }

      class92.method1780();
   }
}
