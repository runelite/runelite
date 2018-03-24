import java.util.Iterator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
@Implements("Size")
public class Size {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   public static final Size field343;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   public static final Size field335;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   public static final Size field334;
   @ObfuscatedName("cv")
   public static char field341;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 1746983793
   )
   static int field342;
   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   static TextureProvider field336;
   @ObfuscatedName("a")
   final String field338;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1560505711
   )
   final int field337;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1767971937
   )
   final int field339;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -193283801
   )
   final int field340;

   static {
      field343 = new Size("SMALL", 1, 0, 4);
      field335 = new Size("MEDIUM", 0, 1, 2);
      field334 = new Size("LARGE", 2, 2, 0);
   }

   Size(String var1, int var2, int var3, int var4) {
      this.field338 = var1;
      this.field337 = var2;
      this.field339 = var3;
      this.field340 = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(FB)Z",
      garbageValue = "0"
   )
   boolean method189(float var1) {
      return var1 >= (float)this.field340;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)Lla;",
      garbageValue = "1"
   )
   static SpritePixels method190(int var0, int var1, int var2) {
      class213 var3 = WorldMapRegion.field457;
      long var4 = (long)(var2 << 16 | var0 << 8 | var1);
      return (SpritePixels)var3.method3951(var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-14098"
   )
   static void method194() {
      Iterator var0 = class95.messages.iterator();

      while(var0.hasNext()) {
         MessageNode var1 = (MessageNode)var0.next();
         var1.method1169();
      }

   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "-71"
   )
   static final void method193(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.menuBooleanArray[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-376561332"
   )
   static void method188(Buffer var0, int var1) {
      BuildType.method4551(var0.payload, var1);
      if(class167.randomDat != null) {
         try {
            class167.randomDat.seek(0L);
            class167.randomDat.write(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }
}
