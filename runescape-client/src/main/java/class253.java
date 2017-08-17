import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
public class class253 extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static NodeCache field3382;
   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   static IndexDataBase field3385;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3383;

   static {
      field3382 = new NodeCache(64);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "1433200827"
   )
   void method4474(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3383 = FileRequest.method4109(var1, this.field3383);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2071361686"
   )
   public String method4472(int var1, String var2) {
      return class29.method261(this.field3383, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1950701128"
   )
   public int method4479(int var1, int var2) {
      return ChatLineBuffer.method1892(this.field3383, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-989041061"
   )
   void method4475() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "647397733"
   )
   void method4473(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4474(var1, var2);
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "-1"
   )
   static final void method4495(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      PendingSpawn var9 = null;

      for(PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.getFront(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0 == var10.level && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new PendingSpawn();
         var9.level = var0;
         var9.type = var3;
         var9.x = var1;
         var9.y = var2;
         class43.method650(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1214 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
