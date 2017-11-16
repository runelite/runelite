import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class20 {
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static IndexedSprite field307;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1730713578"
   )
   static void method148(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      FileRequest var4 = (FileRequest)class245.field3313.get(var2);
      if(var4 != null) {
         class245.field3305.setHead(var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1201399424"
   )
   static void method147(boolean var0) {
      class91.loginMessage1 = "";
      class91.loginMessage2 = "Enter your username/email & password.";
      class91.loginMessage3 = "";
      class91.loginIndex = 2;
      if(var0) {
         class91.password = "";
      }

      if(class91.username == null || class91.username.length() <= 0) {
         if(class70.preferences.field1232 != null) {
            class91.username = class70.preferences.field1232;
            class91.field1352 = true;
         } else {
            class91.field1352 = false;
         }
      }

      class60.method970();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Let;",
      garbageValue = "8"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class31.method245(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "735042287"
   )
   public static void method149() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1770293498"
   )
   static final void method150(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
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
         class60.method967(var9);
         Client.pendingSpawns.addFront(var9);
      }

      var9.id = var4;
      var9.field1136 = var5;
      var9.orientation = var6;
      var9.delay = var7;
      var9.hitpoints = var8;
   }
}
