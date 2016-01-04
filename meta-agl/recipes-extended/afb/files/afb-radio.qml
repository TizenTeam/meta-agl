import QtQuick 2.1
import QtQuick.Controls 1.1
import QtWebEngine 1.1

ApplicationWindow {
	width: 1024
	height: 768
	visible: true
	WebEngineView {
		url: "http://localhost:1234/opa"
		anchors.fill: parent
	}
}
