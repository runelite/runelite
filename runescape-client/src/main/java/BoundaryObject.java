import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
@Implements("BoundaryObject")
public final class BoundaryObject {
   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   @Export("__ej_jv")
   static Widget __ej_jv;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -9307913
   )
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 860688417
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -260081891
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1724480965
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -969316473
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("entity1")
   public Entity entity1;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lex;"
   )
   @Export("entity2")
   public Entity entity2;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -4401157754236673285L
   )
   @Export("tag")
   public long tag;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -693868549
   )
   @Export("flags")
   int flags;

   BoundaryObject() {
      this.tag = 0L;
      this.flags = 0;
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "103"
   )
   static final void method3235(String var0) {
      if(var0.equalsIgnoreCase("toggleroof")) {
         ReflectionCheck.clientPreferences.roofsHidden = !ReflectionCheck.clientPreferences.roofsHidden;
         WorldMapSection0.method247();
         if(ReflectionCheck.clientPreferences.roofsHidden) {
            WorldMapIcon1.method219(99, "", "Roofs are now all hidden");
         } else {
            WorldMapIcon1.method219(99, "", "Roofs will only be removed selectively");
         }
      }

      if(var0.equalsIgnoreCase("displayfps")) {
         Client.displayFps = !Client.displayFps;
      }

      if(var0.equalsIgnoreCase("renderself")) {
         Client.renderSelf = !Client.renderSelf;
      }

      if(var0.equalsIgnoreCase("mouseovertext")) {
         Client.showMouseOverText = !Client.showMouseOverText;
      }

      if(Client.rights >= 2) {
         if(var0.equalsIgnoreCase("errortest")) {
            throw new RuntimeException();
         }

         if(var0.equalsIgnoreCase("showcoord")) {
            class60.worldMap0.showCoord = !class60.worldMap0.showCoord;
         }

         if(var0.equalsIgnoreCase("fpson")) {
            Client.displayFps = true;
         }

         if(var0.equalsIgnoreCase("fpsoff")) {
            Client.displayFps = false;
         }

         if(var0.equalsIgnoreCase("gc")) {
            System.gc();
         }

         if(var0.equalsIgnoreCase("clientdrop")) {
            class48.method868();
         }
      }

      PacketBufferNode var1 = Interpreter.method1915(ClientPacket.__gs_bo, Client.packetWriter.isaacCipher);
      var1.packetBuffer.writeByte(var0.length() + 1);
      var1.packetBuffer.writeStringCp1252NullTerminated(var0);
      Client.packetWriter.__q_167(var1);
   }
}
